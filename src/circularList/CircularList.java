package circularList;
import node.node;

public class CircularList<T> {
	private node<T> sentinel=null;
	private node<T> actual=null;
	int indoce=1;
	
	public CircularList() {
		sentinel = new node<T>();
		actual = new node<T>();
		sentinel.setIndex(-1);
		actual.setIndex(-1);
	}
	public CircularList(T value){
		this();
		sentinel.setNext(new node<T>(value));
		actual = sentinel.getNext();
		sentinel.getNext().setNext(actual);
	}
	
	public void AddFirst(T value){
		node<T> nuevo = new node<T>(value),last = getLast();
		if(isEmpty()){
			sentinel.setNext(nuevo);
			nuevo.setNext(nuevo);
		}else{
			nuevo.setNext(sentinel.getNext());
			sentinel.setNext(nuevo);
			last.setNext(nuevo);
		}
	}
	
	private node<T> Search(T value,node<T> list){
		if(list.getNext().getValue().equals(value)){
			return list.getNext();
		}
		if(list.getNext().equals(sentinel.getNext())){
			return null;
		}
		
		return Search(value,list.getNext());
	}
	
	public node<T> Search(T value){
		return (!isEmpty())?Search(value,sentinel.getNext()):null;
	}
	
	public node<T> SearchBefore(T value){
		return SearchBefore(value, sentinel.getNext());
	}
	
	private node<T> SearchBefore(T value,node<T> list){
		if (list.getNext().equals(sentinel.getNext())){
			return null;
		}
		else if (list.getNext().getValue().equals(value)){
			return list;
		}
		return SearchBefore(value,list.getNext());
	}
	
	public boolean Remmove(T value){
		
		node<T> found = Search(value);
		node<T> tmp = SearchBefore(value,sentinel.getNext());
		if(!isEmpty()){
			if(found != null){
				if(tmp.equals(tmp.getNext()))
					sentinel.setNext(null);
				else {
					if(sentinel.getNext().equals(found)){
					sentinel.setNext(found.getNext());
					tmp.setNext(found.getNext());
					}
					else {
					tmp.setNext(found.getNext());
					}
				}
			}
		}
		return true;
	}
	
	public node<T> indexOf(T value, node<T> lista){
		if(lista.getValue().equals(value)) 
		{
			return lista;
		}else{
			if (lista.getNext()==sentinel.getNext())
			{
			return null;
			}
		}
		return indexOf(value, lista.getNext());
	}
	
	private void ReIndexar() {
		
		node<T> tmp = sentinel.getNext();
		if(!isEmpty())
		{
			do{
				tmp.setIndex(indoce);
				indoce++;
				tmp = tmp.getNext();
			}while (!tmp.getNext().equals(sentinel.getNext()));
			tmp.setIndex(indoce);
			System.gc();
		}
	}
	
	public boolean RemmoveLast(){
		node<T> last = getLast();
		node<T> found = Search(last.getValue());
		if(!isEmpty())
		{
			if(found != null)
			{
				node<T> tmp = SearchBefore(last.getValue(), sentinel.getNext());
				if(tmp.equals(tmp.getNext()))
					sentinel.setNext(null);
				else{ 
					if(sentinel.getNext().equals(found)){
					 sentinel.setNext(found.getNext());
					 tmp.setNext(found.getNext());
				 }else{
					 tmp.setNext(found.getNext());
				 }
			}
		}
	}
		return true;
	}
	
	public void RemmoveAfter(T value)
	{
		node<T> tmp=Search(value);
		
		if(!isEmpty())
		{
			if (tmp!=null)
			{
				if(tmp.getNext().equals(sentinel.getNext()))
				{
					tmp.setNext(tmp.getNext().getNext());
					sentinel.setNext(sentinel.getNext().getNext());
				}else{
					tmp.setNext(tmp.getNext().getNext());
				}
			}
		}
	}
	
	public boolean isEmpty(){
		return (sentinel.getNext() == null)?true:false;
	}
	
	public node<T> getLast(){
		node<T> tmp = sentinel.getNext();
		if(!isEmpty()){
			while(!sentinel.getNext().equals(tmp.getNext())){
				tmp = tmp.getNext();
			}
			return tmp;
		}
		return null;
	}
	
	public T RemmoveBefore(T value){
		 return RemmoveBefore(value,sentinel); 
		 
	 }
	 private T RemmoveBefore(T value, node<T> lista){
		 node<T> tmp = lista;			
		 lista=lista.getNext();
		 if(lista.getNext().getValue().equals(value)){
			 tmp.setNext(tmp.getNext().getNext()); 
		 }else{
			 return RemmoveBefore(value,lista); 
		 }
		 return value;
	 }
	 
	 public void Size(){
		 node<T> tmp = sentinel.getNext();
		 int cont = 0;
		while(tmp != null && tmp !=sentinel){
			cont++;
		}
		System.out.println("El tamaño: " + cont);
	 }
	 
	/*public node<T> size(node<T> ){
		
	
		
		if(tmp != null )
		{
			cont++;
			return (tmp.getNext());
		}
	}*/
	public void GetFirst(){
		System.out.println(sentinel.getNext().getValue());
	}
	
	public void RemmoveFirst(){
		Remmove(sentinel.getNext().getValue());
	}
	
	 public void Repllace(T value, T remp){
		 Search(value).setValue(remp);
	 }
	
	public node<T> indexOf(T value){
		ReIndexar();
		return indexOf (value,sentinel.getNext());
	}
	
	public void Printer(){
		node<T> tmp = sentinel.getNext();
		if(!isEmpty())
		while(!tmp.getNext().equals(sentinel.getNext()))
		{
			System.out.println(tmp.getValue());
			tmp = tmp.getNext();
		}
		System.out.println(tmp.getValue());
	}
	
	public void clear(){
		 sentinel.setNext(null);
	     System.gc();
	 }
}
