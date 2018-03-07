import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    Stack<Integer> integerStack;
    Stack<Character> characterStack;

    @BeforeEach
    void init() {
        integerStack = new Stack<>(4);
        characterStack = new Stack<>(5);
    }

    @org.junit.jupiter.api.Test
    void pushInteger() {
        integerStack.push(1);
        assertEquals(integerStack.toString(), "[1, null, null, null]");
    }

    @org.junit.jupiter.api.Test
    void pushCharacter() {
        characterStack.push('b');
        assertEquals(characterStack.toString(), "[b, null, null, null, null]");
    }

    @org.junit.jupiter.api.Test
    void popInteger() {
        integerStack.push(2);
        integerStack.push(3);
        integerStack.push(5);
        assertEquals((Integer)5, integerStack.pop());
    }

    @org.junit.jupiter.api.Test
    void popCharacter() {
        characterStack.push('a');
        characterStack.push('b');
        assertEquals((Character)'b', characterStack.pop());
    }

    @org.junit.jupiter.api.Test
    void pushEdge() {
        characterStack.push('a');
        characterStack.push('b');
        characterStack.push('c');
        characterStack.push('c');
        characterStack.push('c');
        assertThrows(StackOverflow.class,() -> characterStack.push('d'));
    }

    @org.junit.jupiter.api.Test
    void freeSpace() {
        characterStack.push('a');
        characterStack.push('b');
        assertEquals(3, characterStack.freeSpaces());
    }

    @org.junit.jupiter.api.Test
    void freeSpaceEmpty() {
        assertEquals(5, characterStack.freeSpaces());
    }

    @org.junit.jupiter.api.Test
    void freeSpaceFull() {
        characterStack.push('a');
        characterStack.push('b');
        characterStack.push('c');
        characterStack.push('c');
        characterStack.push('c');
        assertEquals(0, characterStack.freeSpaces());
    }

}