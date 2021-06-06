package moshi_przyklad;

public class FullNode extends Node {
    final int value;
    final Node left, right;

    FullNode(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "[" + this.value + "," + this.left + "," + this.right + "]";
    }
}