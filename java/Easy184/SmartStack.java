public class SmartStack<T extends Comparable<T>> {
    List<Node> nodes = new ArrayList<>();
    Node top;

    public void push(T item) {
        Node newNode = new Node(item);
        newNode.below = top;
        if (top != null) {
            top.above = newNode;
        }
        top = newNode;
        nodes.add(newNode);
        Collections.sort(nodes);
    }

    public T pop() {
        if (size() < 1)
            throw new NoSuchElementException("SmartStack is empty.");
        return remove(top);
    }

    public int size() {
        return nodes.size();
    }

    public void displayStack() {
        StringBuilder sb = new StringBuilder();
        Node node = top;
        while (node != null) {
            sb.append(node + " ");
            node = node.below;
        }
        System.out.println(sb.toString());
    }

    public void displayOrdered() {
        StringBuilder sb = new StringBuilder();
        for (Node node : nodes) {
            sb.append(node + " ");
        }
        System.out.println(sb.toString());
    }

    public void removeGreater(T item) {
        Node borderNode = new Node(item);
        List<Node> toRemove = new ArrayList<>();
        for (Node node : nodes) {
            if (node.compareTo(borderNode) > 0) {
                toRemove.add(node);
            }
        }
        for (Node node : toRemove) {
            remove(node);
        }
    }

    private T remove (Node node) {
        if (node.below != null) {
            node.below.above = node.above;
        }
        if (node.above != null) {
            node.above.below = node.below;
        }
        if (node == top) {
            top = node.below;
        }
        nodes.remove(node);
        Collections.sort(nodes);
        return node.item;
    }

    private class Node implements Comparable<Node> {
        T item;
        Node below;
        Node above;

        private Node(T item) {
            this.item = item;
        }

        @Override
        public int compareTo(Node aNode) {
            return item.compareTo(aNode.item);
        }

        @Override
        public String toString() {
            return item.toString();
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        SmartStack<Integer> smartStack = new SmartStack<>();

        int n = random.nextInt(40) + 1;

        for (int i = 0; i < n; i++) {
            smartStack.push(random.nextInt(2001) - 1000);
        }

        smartStack.displayStack();
        smartStack.displayOrdered();

        int x = random.nextInt(2001) - 1000;

        smartStack.removeGreater(x);

        smartStack.displayStack();
        smartStack.displayOrdered();

        int timesToPop = smartStack.size() / 2;
        for (int i = 0; i < timesToPop; i++) {
            smartStack.pop();
        }

        smartStack.displayStack();
        smartStack.displayOrdered();
    }
}