public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.insertNode(10);
        tree.insertNode(-2);
        tree.insertNode(-4);
        tree.insertNode(-1);
        tree.insertNode(20);
        tree.insertNode(15);
        tree.insertNode(30);
        tree.insertNode(12);
        tree.insertNode(17);
        tree.insertNode(40);
        tree.insertNode(28);
        tree.insertNode(29);
        tree.insertNode(27);
        tree.CallRootLeftRight();
        tree.CallLeftRightRoot();
        tree.CallLeftRootRight();
        tree.DeleteNode(20);
        tree.CallLeftRootRight();
        BinaryTree<Student> studentTree = new BinaryTree<Student>();
        Student student1 = new Student("Bob","Marley",110);
        Student student2 = new Student("John" ,"Lennon",8);
        Student student3 = new Student("Pol","Mackartney",12);
        Student student4 = new Student("Remington","Smith",7);
        Student student5 = new Student("Jacob","de la Rose",125);
        Student student6 = new Student("Benito","Mussolini",6);
        Student student7 = new Student("Mark","Tween",7);
        Student student8 = new Student("Martin","Korridon",11);
        studentTree.insertNode(student1);
        studentTree.insertNode(student2);
        studentTree.insertNode(student3);
        studentTree.insertNode(student4);
        studentTree.insertNode(student5);
        studentTree.insertNode(student6);
        studentTree.insertNode(student7);
        studentTree.insertNode(student8);
        studentTree.CallLeftRootRight();
    }
}