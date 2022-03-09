package hw2;
import intlist.IntLinkedList.Node;

public class DoubleLink {
		private int length;
		private Node head;
		private Node bottom; 
		
		private class Node {
			private Professor data;
			private Node prev;
			private Node next;
			private Node(Professor data) {
				this.data = data;
				prev = null;
				next = null;
			}
			private Node(Professor data, Node prev) {
				this.data = data;
				this.prev = prev;
				next = null;
				
			}
			private Node(Professor data, Node prev, Node next) {
				this.data = data;
				this.prev = prev;
				this.next = next;
			}
		}
		
		public DoubleLink(){
			head = null;
			bottom = null;
			length = 0;

		}
		public  Professor search(String name, int rarity) {
			Node current = head;
			while (current != null) {
				if (name == current.data.getName() && rarity == current.data.getRarity()) {
					return current.data;
				}
			current = current.next;
			}
			return null; 
		}
		public delete(Professor professor) {
			if(length == 0) {
				throw new UnsupportedOperationException();
			}
			Node current = head;
			for(int i = 0; i < length; i++) {
				if(current.next != null) {
					if(current.prev != null) {
						Node previous = current.prev;
						previous.next = current.next;
					}
				}
				if(current.data.equals(professor) && length == 1) {
					head.data = null;
					length --;	
				}
				if(current.next == null) {
					Node previous = current.prev;
					previous.next = null;
				}
				if(current.prev == null) {
					head = current.next;
					head.prev = null;
				}
				current.data = null;
				length --;
				current = current.next;
				
			}
		}
		public Professor getAt(int p) {
			if(p < 0 || p>= length) {
				throw new UnsupportedOperationException();
			}
			Node current = head;
			for(int i = 0; i < length; i++) {
				current = current.next;
			}
			return current.data;
		}
		public removeAt(int i) {
			if(i<0 || i >= length) {
				throw new UnsupportedOperationException();
			}
			if(length == 1) {
				head.data = null;
				length --;
				return;
			}
			Node current = head;
			for(int i = 0; i < length; i++) {
				current = current.next;
			}
			if(current.next == null) {
				Node previous = current.prev;
				previous.next = null;
			}
			if(current.prev == null)
		}	
			
		
}
