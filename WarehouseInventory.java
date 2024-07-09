package A2;

import java.sql.SQLOutput; //output stream for writing attributes of a user-defined type back to the database

public class WarehouseInventory implements ADTDictionary<String, Inventory> {

    private Inventory Inv;
    private String String;

    private LList<String, Inventory> InventoryList = new LList<>();

    WarehouseInventory(){
        LList<String, Inventory> Inventory2List = new LList<>();
    }

    public void clear(){
        InventoryList.clear();
    }

    public void insert(String string, Inventory inventory2){
        InventoryList.insert(string, inventory2);

    }

    public Inventory find(String String) {
        if (InventoryList.head == null) {
            return null;
        }
        Node<String, Inventory> curr = InventoryList.head;
        while (curr != null) {
            if (curr.k() == String) {
                System.out.println(curr.v() + " <--- is the value associated to the key");
                return curr.v();
            }
            curr = curr.next();
        }
        return curr.v();
    }
    public Inventory remove(String String){
        Node<String, Inventory> curr = InventoryList.head;
        Node<String, Inventory> tmp = null;

        if (curr != null &&  curr.k() == String){
            InventoryList.remove();
            InventoryList.cnt--;
            return curr.v();
        }
        while(curr != null && curr.k() != String){
            tmp = curr;
            curr = curr.next();
            if(curr == null){
                InventoryList.remove();
                InventoryList.cnt--;
                return curr.v();
            }

        }
        InventoryList.cnt--;

        tmp.setNext(curr.next());
        return null;
    }

    public Inventory removeAny(){
        if(InventoryList.head != null){
            Inventory tmp = InventoryList.getValue();
            InventoryList.remove();
            return tmp;

        } else{
            return null;
        }
    }


    public int size() {
        System.out.println(InventoryList.length() + " is the length of the Inventory2 list");
        return InventoryList.length();
    }

    @Override
    public Inventory[] createIndex(String attribute) {
        final Inventory[] copyInventory2 = copyInventory();

        if(attribute.equals("UnitPrice")){
            quicksort(copyInventory2,0, copyInventory().length-1, "UnitPrice");
            return copyInventory2;
        } else if (attribute.equals("QtyInStock")){
            quicksort(copyInventory2,0, copyInventory().length-1, "QtyInStock");
            return copyInventory2;
        } else if (attribute.equals("InvValue")){
            quicksort(copyInventory2,0, copyInventory().length-1, "InvValue");
            return copyInventory2;
        } else if(attribute.equals("ReorderL")){
            quicksort(copyInventory2,0, copyInventory().length-1, "ReorderL");
            return copyInventory2;
        } else if(attribute.equals("ReorderT")){
            quicksort(copyInventory2,0, copyInventory().length-1, "ReorderT");
            return copyInventory2;
        } else if(attribute.equals("QtyReorder")){
            quicksort(copyInventory2,0, copyInventory().length-1, "QtyReorder");
            return copyInventory2;
        }
        return copyInventory2;
    }

    private Inventory[] copyInventory(){

        Inventory[] copy = new Inventory[InventoryList.length()];

        int i = 0;
        for (InventoryList.moveToStart(); InventoryList.currPos() < InventoryList.length(); InventoryList.next()){
            final Inventory value = InventoryList.getValue();
            copy[i++] = value;
        }
        return copy;
    }

    public void quicksort (Inventory[] copy, int start, int end, String attribute) {//ask TA about how to access specific attribute
        int qs;

                                                                  //Asymptotic Analysis:
        if (end > start){                                         //Time Complexity: O(nlogn)
            qs = partition(copy, start, end, attribute);          //Space Complexity: O(n)
            quicksort(copy, start, qs, attribute);
            quicksort(copy, qs + 1, end, attribute);
        }

    }


    int partition(Inventory[] copy, int start, int end,String attribute){
        Inventory P = copy[start];
        int i = start;

        if(attribute.equals("UnitPrice")) {
            for (int j = start + 1; j <= end; j++) {
                if (copy[j].p() > copy[start].p()) {
                    i++;
                    swap(copy, i, j);
                }
            }
        } else if (attribute.equals("QtyInStock")) {
            for (int j = start + 1; j <= end; j++) {
                if (copy[j].q() > copy[start].q()) {
                    i++;
                    swap(copy, i, j);
                }
            }
        } else if (attribute.equals("InvValue")) {
            for (int j = start + 1; j <= end; j++) {
                if (copy[j].i() > copy[start].i()) {
                    i++;
                    swap(copy, i, j);
                }
            }
        } else if (attribute.equals("ReorderL")) {
            for (int j = start + 1; j <= end; j++) {
                if (copy[j].rl() > copy[start].rl()) {
                    i++;
                    swap(copy, i, j);
                }
            }
        } else if (attribute.equals("ReorderT")){
            for (int j = start + 1; j <= end; j++) {
                if (copy[j].rt() > copy[start].rt()) {
                    i++;
                    swap(copy, i, j);
                }
            }
        } else if (attribute.equals("QtyReorder")) {
            for (int j = start + 1; j <= end; j++) {
                if (copy[j].rq() > copy[start].rq()) {
                    i++;
                    swap(copy, i, j);
                }
            }
        }
        swap(copy, i, start);
        return i;
    }

    private void swap(Inventory[] arr, int i, int j){
        Inventory tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;

    }

    @Override
    public BSTNode<Inventory> createBSTIndex(String attribute){

        BSTNode<Inventory> BST = new BSTNode<Inventory>();
        final Inventory[] inventory = copyInventory(); // array of inventories that become BST

       //BST.setElement(inventory[0]); initial root
        int i = 0;
        if(attribute.equals("UnitPrice")){
            BST.setElement(inventory[i]);
            for (i = 1; i < inventory.length; i++) {
                if (inventory[i].p() < inventory[i-1].p() ) {
                        BST.setLeft(inventory[i]);  //check if this work in unit testing
                } else {
                    BST.setRight(inventory[i]); //check if this work in unit testing
                }
            }
            ascendingOrder(BST);
        } else if (attribute.equals("QtyInStock")) {
            BST.setElement(inventory[i]);
            for (i = 1; i < inventory.length; i++) {
                if (inventory[i].q() < inventory[i-1].q() ) {
                    BST.setLeft(inventory[i]);
                } else {
                    BST.setRight(inventory[i]);
                }
            }
            ascendingOrder(BST);
        } else if (attribute.equals("InvValue")) {
            BST.setElement(inventory[i]);
            for (i = 1; i < inventory.length; i++) {
                if (inventory[i].i() < inventory[i-1].i() ) {
                    BST.setLeft(inventory[i]);
                } else {
                    BST.setRight(inventory[i]);
                }
            }
            ascendingOrder(BST);
        } else if (attribute.equals("ReorderL")) {
            BST.setElement(inventory[i]);
            for (i = 1; i < inventory.length; i++) {
                if (inventory[i].rl() < inventory[i-1].rl() ) {
                    BST.setLeft(inventory[i]);
                } else {
                    BST.setRight(inventory[i]);
                }
            }
            ascendingOrder(BST);
        } else if (attribute.equals("ReorderT")) {
            BST.setElement(inventory[i]);
            for (i = 1; i < inventory.length; i++) {
                if (inventory[i].rt() < inventory[i-1].rt() ) {
                    BST.setLeft(inventory[i]);
                } else {
                    BST.setRight(inventory[i]);
                }
            }
            ascendingOrder(BST);
        } else if (attribute.equals("QtyReorder")) {

            BST.setElement(inventory[i]);
            for (i = 1; i < inventory.length; i++) {
                if (inventory[i].rq() < inventory[i-1].rq() ) {
                    BST.setLeft(inventory[i]);
                } else {
                    BST.setRight(inventory[i]);
                }
            }
            ascendingOrder(BST);
        }

        return BST; //return root of the tree
    }

    public void ascendingOrder(BSTNode<Inventory> root){
        inOrderTraversing(root);
        //ascending order result
        //return null;
    }

    public void inOrderTraversing(BSTNode<Inventory> BST){
        if (BST != null){
            inOrderTraversing(BST.left());
            inOrderTraversing(BST.right());
        }
    }

    @Override
    public void query(String attribute, double perct){

        Inventory[] qInv = createIndex(attribute);

        int N = qInv.length;
        int pivot = (int) (N * perct); //no need for lower bound because int truncates no matter the value after the dot

        if ( attribute.equals("UnitPrice")){
            if (perct == 0){
                double result = qInv[0].p();
                System.out.println("The percentile "+ perct +" of Unit Price is: " + result);
            } else if (perct == 1){
                double result = qInv[N-1].p();
                System.out.println("The percentile "+ perct +" of Unit Price is: " + result);
            } else {
                double result = qInv[pivot - 1].p();
                System.out.println("The percentile "+ perct +" of Unit Price is: " + result);
            }
        } else if (attribute.equals("QtyInStock")) {
            if (perct == 0){
                int result = qInv[0].q();
                System.out.println("The percentile "+ perct +" of Quantity in Stock is: " + result);
            } else if (perct == 1){
                int result = qInv[N-1].q();
                System.out.println("The percentile "+ perct +" of Quantity in Stock is: " + result);
            } else {
                int result = qInv[pivot - 1].q();
                System.out.println("The percentile "+ perct +" of Quantity in Stock is: " + result);
            }
        } else if (attribute.equals("InvValue")){
            if (perct == 0){
                double result = qInv[0].i();
                System.out.println("The percentile "+ perct +" of Inventory Value is: " + result);
            } else if (perct == 1){
                double result = qInv[N-1].i();
                System.out.println("The percentile "+ perct +" of Inventory Value is: " + result);
            } else {
                double result = qInv[pivot - 1].i();
                System.out.println("The percentile "+ perct +" of Inventory Value is: " + result);
            }
        } else if (attribute.equals("ReorderL")) {
            if (perct == 0){
                int result = qInv[0].rl();
                System.out.println("The percentile "+ perct +" of Reorder Level is: " + result);
            } else if (perct == 1){
                int result = qInv[N-1].rl();
                System.out.println("The percentile "+ perct +" of Reorder Level is: " + result);
            } else {
                int result = qInv[pivot - 1].rl();
                System.out.println("The percentile "+ perct +" of Reorder Level is: " + result);
            }
        } else if (attribute.equals("ReorderT")) {
            if (perct == 0){
                int result = qInv[0].rt();
                System.out.println("The percentile "+ perct +" of Reorder Time is: " + result);
            } else if (perct == 1){
                int result = qInv[N-1].rt();
                System.out.println("The percentile "+ perct +" of Reorder Time is: " + result);
            } else {
                int result = qInv[pivot - 1].rt();
                System.out.println("The percentile "+ perct +" of Reorder Time is: " + result);
            }
        } else if (attribute.equals("QtyReorder")) {
            if (perct == 0){
                int result = qInv[0].rq();
                System.out.println("The percentile "+ perct +" of Reorder Quantity is: " + result);
            } else if (perct == 1){
                int result = qInv[N-1].rq();
                System.out.println("The percentile "+ perct +" of Reorder Quantity is: " + result);
            } else {
                int result = qInv[pivot - 1].rq();
                System.out.println("The percentile "+ perct +" of Reorder Quantity is: " + result);
            }
        } else {
            System.out.println("Invalid attribute, please type an attribute that is an integer or double");
        }

    }



}