package se.johan.lektion3.uppgift;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class CounterController {

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/counter")
    public Counter counter() {
        long value = counter.incrementAndGet();
        return new Counter(1, (int) value);
    }

    // Ska vara @Post egentligen men kör med @Get för att få det att fungera.
    @GetMapping("counter/reset")
    public Counter resetCounter() {
        counter.set(0);
        return new Counter(1, (int) counter.get());
    }
}
