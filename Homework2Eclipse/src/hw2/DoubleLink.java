package hw2;


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
				next = null;
				prev = null;
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
		public void delete(Professor professor) {
			if(length == 0) {
				throw new UnsupportedOperationException();
			}
			Node current = head;
			for(int i = 0; i < length; i++) {
				
				if(current.data == professor) {
					if(length == 1) {
					head.data = null;
					head = null;
					length --;	
					break;
					}
				
					if(current.next == null) {
						Node prevNode = current.prev;
						prevNode.next = null;
					}
					if(current.prev == null) {
						head = current.next;
						head.prev = null;
					}
					if(current.next != null && current.prev != null) {
						Node prevNode = current.prev;
						prevNode.next = current.next;
						current.prev = prevNode;
					}
					current.data = null;
					length --;
				} else {
					current = current.next;
				}
			}
		}
		public void empty(Professor professor) {
			if(length <= 0) {
				throw new UnsupportedOperationException();
			} else {
				Node current = head;
				for(int i = 0; i < length; i++) {
					current = current.next;
				}
				current.data = null;
			}
		}
		public Professor getAt(int p) {
			if(p < 0 || p>= length) {
				throw new UnsupportedOperationException();
			}
			
			Node current = head;
			for(int i = 0; i < p; i++) {
				current = current.next;
			}
			return current.data;
		}
		public void append(Professor data) {
			Node toAppend = new Node(data);
			if(length == 0) {
				head = toAppend;	
			} else {
				bottom.next = toAppend;
			}
			toAppend.next = bottom;
			bottom = toAppend;
			length++;
		}
		public int length() {
			return length;
		}
		public int index(String name, int rarity) {
			Node current = head;
			for(int i = 0; i < length; i++) {
				if(current.data != null) {
					if(name.equals(current.data.getName()) && rarity == current.data.getRarity()) {
						return i;
					}
					current = current.next;
				}
			}
			return -1;
		}
		
}
