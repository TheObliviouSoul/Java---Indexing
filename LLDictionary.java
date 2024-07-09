package A2;

import A2.ADTDictionary;

public class LLDictionary<K, E> implements ADTDictionary<K,E> {

    private LList<K,E> list = new LList<>();

    /** Constructors */
     LLDictionary(){
        LList<K,E> list = new LList<>();
    }

    /** Clean */
    public void clear(){
        list.clear(); //uses the clear function implemented for the LList.java file.
    }

    /** Insert */
    @Override
    public void insert(K k, E e) {
        list.insert(k,e);
    }

    /** Remove function*/
    public E remove(K k){
        //list.remove();

        Node<K, E> curr = list.head;
        Node<K, E> tmp = null;

        if (curr != null &&  curr.k() == k){
            list.remove();
            list.cnt--;
            return curr.v();
        }
        while(curr != null && curr.k() != k){
            tmp = curr;
            curr = curr.next();
            if(curr == null){
                list.remove();
                list.cnt--;
                return curr.v();
            }

        }
        list.cnt--;

        tmp.setNext(curr.next());
        
        return null;
    }
        public E removeAny(){

            if(list.head != null){
                E tmp = list.getValue();
                list.remove();
                System.out.println(tmp +" was the value of the current node removed");
                return tmp;

            } else{
                return null;
            }
            
        }
            
            public E find(K k){
                if(list.head==null){
                    return null;
                }
                Node<K,E> curr = list.head;
                while(curr != null){
                    if(curr.k() == k){
                        System.out.println(curr.v() + " <--- is the value associated to the key");
                        return curr.v();
                    }
                    curr = curr.next();
                }
                return null;
            }

            /** Prints out length of the linked list*/
            public int size(){
                System.out.println(list.length() + " is the length of the linked list");
                return list.length();
            }

            @Override
            public E[] createIndex(String attribute) {
                return null;
            }

            @Override
            public BSTNode<E> createBSTIndex(String attribute) {
                return null;
            }

            @Override
            public void query(String attribute, double perct) {

            }
        }