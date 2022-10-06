public class BinaryTree <T extends Comparable<T>>{
    class Node
    {
        T value;
        Node rightChild;
        Node leftChild;
        public Node(T value)
        {
            this.value = value;
            rightChild = null;
            leftChild = null;
        }
    }
    private Node root;
    public BinaryTree()
    {
        root = null;
    }
    public void insertNode(T value1)
    {
        Node newNode = new Node(value1);
        Node currentNode = root;
        Node parentNode;
        if(root == null)
        {
            root = newNode;
        }
        else {
            while (true)
            {
                parentNode = currentNode;
                if(parentNode.value.compareTo(value1) == 0)
                {
                    return;
                }
                else if(parentNode.value.compareTo(value1) > 0)
                {
                    currentNode = parentNode.leftChild;
                    if(currentNode == null)
                    {
                        parentNode.leftChild = newNode;
                        return;
                    }
                }
                else
                {
                    currentNode = parentNode.rightChild;
                    if(currentNode == null)
                    {
                        parentNode.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }
    public void CallRootLeftRight()
    {
        System.out.println("RootLeftRight: ");
        RootLeftRight(root);
    }
    public void CallLeftRootRight()
    {
        System.out.println("LeftRootRight: ");
        LeftRootRight(root);
    }
    public void CallLeftRightRoot()
    {
        System.out.println("LeftRightRoot: ");
        LeftRightRoot(root);
    }
    public void RootLeftRight(Node rlrNode)
    {
        if(rlrNode == null)
        {
            return;
        }
        System.out.println(rlrNode.value);
        RootLeftRight(rlrNode.leftChild);
        RootLeftRight(rlrNode.rightChild);
    }
    public void LeftRootRight(Node lr)
    {
        if(lr == null)
        {
            return;
        }
        LeftRootRight(lr.leftChild);
        System.out.println(lr.value);
        LeftRootRight(lr.rightChild);
    }
    public void LeftRightRoot(Node lrrNode)
    {
        if(lrrNode == null)
        {
            return;
        }
        LeftRightRoot(lrrNode.leftChild);
        LeftRightRoot(lrrNode.rightChild);
        System.out.println(lrrNode.value);
    }
    public boolean FindElement(T valueToFind)
    {
        Node currentNode = root;
        if(root == null)
        {
            return false;
        }
        while(currentNode != null)
        {
            if(currentNode.value.compareTo(valueToFind) == 0)
            {
                return true;
            }
            else if(currentNode.value.compareTo(valueToFind) > 0)
            {
                currentNode = currentNode.leftChild;
            }
            else {
                currentNode = currentNode.rightChild;
            }
        }
        return false;
    }
    public void DeleteNode(T valueToDelete)
    {
        if (root == null) {
            System.out.println("Empty tree");
            return;
        }
        Node currentNode = root;
        Node parentNode = root;
        boolean isRight = false;
        while (valueToDelete != currentNode.value)
        {
            parentNode = currentNode;
            if(currentNode.value.compareTo(valueToDelete) > 0)
            {
                isRight = false;
                currentNode = currentNode.leftChild;
            }
            else
            {
                isRight = true;
                currentNode = currentNode.rightChild;
            }
            if(currentNode == null)
            {
                System.out.println("No such element");
                return;
            }
        }
        if(currentNode.leftChild == null && currentNode.rightChild == null)
        {
            if(currentNode == root)
                root = null;
            if(isRight)
                parentNode.rightChild = null;
            else
                parentNode.leftChild = null;
        }
        else if(currentNode.leftChild == null)
        {
            if(currentNode == root) {
                root = currentNode.rightChild;
            }
            else if(isRight) {
                parentNode.rightChild = currentNode.rightChild;
            }
            else {
                parentNode.leftChild = currentNode.rightChild;
            }
        }
        else if(currentNode.rightChild == null)
        {
            if(currentNode == root)
                root = currentNode.leftChild;
            else if(isRight)
                parentNode.rightChild = currentNode.leftChild;
            else
                parentNode.leftChild = currentNode.leftChild;
        }
        else
        {
            Node parent1Node = currentNode;
            Node newNode = currentNode;
            Node current1Node = currentNode.rightChild;
            while (current1Node != null)
            {
                parent1Node = newNode;
                newNode = current1Node;
                current1Node = current1Node.leftChild;
            }
            if(newNode != currentNode.rightChild)
            {
                parent1Node.leftChild = newNode.rightChild;
                newNode.rightChild = currentNode.rightChild;
            }
            newNode.leftChild = currentNode.leftChild;
            if(currentNode == root)
                root = newNode;
            else if(isRight)
                parentNode.rightChild = newNode;
            else
                parentNode.leftChild = newNode;
        }
    }
}