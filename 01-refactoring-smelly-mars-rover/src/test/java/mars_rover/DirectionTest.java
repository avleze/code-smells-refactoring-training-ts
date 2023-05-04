package mars_rover;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class DirectionTest {
    @Test
    public void creating_directions_given_their_encodings() {
        assertThat(Direction.create("N"), is(Direction.N));
        assertThat(Direction.create("S"), is(Direction.S));
        assertThat(Direction.create("W"), is(Direction.W));
        assertThat(Direction.create("E"), is(Direction.E));
    }
}