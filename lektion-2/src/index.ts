import express, { type Request, type Response } from "express";
import "dotenv/config"; // oneliner for configuration
import { closeDB, getDB, runDB } from "./db/database.js";
import type { User } from "../types/User.js";
import type { Db } from "mongodb";

const app = express();
const port: number = 3001;
app.get("/user", (req: Request, res: Response) => {
  const newUser: User = { id: 10, name: "Johan" };
  res.status(201).send(newUser);
});

app.get("/comments/:username", async (req, res) => {
  const db: Db = getDB();
  const result = await db
    .collection("comments")
    .find({ name: req.params.username })
    .limit(25)
    .toArray();
  if (result.length === 0) {
    res.status(404).send({ message: "Nothing was found" });
    return;
  }
  res.send(result);
});

app.get("/:id", (req: Request, res: Response) => {
  const id: number = Number(req.params.id);
  if (isNaN(id)) {
    res.status(400).send("Not a number");
    return;
  }
  res.send({ id: id });
});

app.get("/", (req: Request, res: Response) => {
  res.send({ message: "Hello world!" });
});

async function startServer() {
  try {
    await runDB();
    app.listen(port, () => {
      console.log(`Listening to port ${port}`);
      console.log(`Start the app: http://localhost:${port}`);
    });
    process.on("SIGINT", async () => {
      console.log("Cleaning up...");
      await closeDB();
      process.exit(0);
    });
  } catch (error) {
    console.log(error);
  }
}
startServer();

/*
app.get("/", (request, response) => {
  response.send({ message: "Hello world" });
});
app.get("/", (request, response) => {
  response.status(200).send({ message: "Hello world" });
});

app.get("/", (request, response) => {
  response.send("Hello world!");
});
*/
