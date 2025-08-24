// Enbart backend utan TSX fil.
import express from "express";
import "dotenv/config";

const app = express();
const port: number = 3000;

const secret = process.env.MY_GLOBAL_TEST_SECRET;

app.get("/", (req, res) => {
  res.status(200).send("Hello !");
});

// Start server on Port Variable
app.listen(port, () => {
  console.log(`Listening on port ${port}`);
  console.log(secret); // Gör endast detta under debug!!!
});
