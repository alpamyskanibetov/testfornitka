package kz.essc.testnitka.task2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Task2 {

	List <Integer> list = new LinkedList<Integer>();
	
	public Task2() {}
	/*
    public static void main(String [] args) {
        List<Integer> list = new LinkedList<Integer>();

        list.add(1);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        list.add(4);
        list.add(4);
        list.add(3);

        removeWithSequence(list, 0);
        
        System.out.print("Task2.1 - ");
        for (Integer i: list)
            System.out.print(i);
        
        System.out.println();
        
        list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        list.add(4);
        list.add(4);
        list.add(3);
    
        System.out.print("Task2.2 - ");
        removeWithoutSequence(list, 0);
    
        for (Integer i: list)
            System.out.print(i);
        
        System.out.println();
    }*/

    
	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}

	public void removeWithSequence(int index) {
        if (list.isEmpty())
            return;
        
        if (list.size() <= index)
            return;

        int number = list.get(index);
        int counter = 0;

        for (int i=index; i < list.size(); i++)
            if (number == list.get(i)) 
                counter++;
            else
                break;

        if (counter >= 3) {
        	for (int i = index; i < index + counter; i++)
        		list.remove(index);
            
        	removeWithSequence(index);
        }
        else
        	removeWithSequence(index+1);
    }

    public void removeWithoutSequence(int index) {
        if (list.isEmpty())
            return;

        if (list.size() <= index)
            return;
        
        int number = list.get(index);
        

        List<Integer> indexesToRemove = new ArrayList<Integer>();
        
        for (int i = list.size()-1; i >=0; i--)
            if (number == list.get(i))
                indexesToRemove.add(i);
        
        if (indexesToRemove.size() >= 3) {
            for (int i: indexesToRemove)
                list.remove(i);

            removeWithoutSequence(index);
        }
        else {
            removeWithoutSequence(index+1);
        }
    }
}
