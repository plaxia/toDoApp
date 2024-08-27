package com.in28minutes.springboot.myfirstwebapp.todo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	
	private static List <Todo> todos=new ArrayList<>();
	private static int toDoCount=0;
	static {
		todos.add( new Todo(++toDoCount, "ruhi", "Learn AWS 1 ", 
				LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++toDoCount, "ruhi", "Learn DevOPS 1", 
				LocalDate.now().plusYears(2), false));
		todos.add(new Todo(++toDoCount, "ruhi", "Learn Full Stack Development 1",
				LocalDate.now().plusYears(3), false));
	}
	
	public List <Todo> findByUsername  (String username){
		Predicate<? super Todo> predicate=todo->todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}
	
	public void addTodo(String username,String description,LocalDate localdate,boolean done) {
		++toDoCount;
		Todo todo=new Todo(toDoCount, username, description, localdate, done);
		todos.add(todo);
	}
	public void deleteById(int id) {
		
		Predicate<? super Todo> predicate=todo->todo.getId()==id;
		todos.removeIf(predicate);
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate=todo->todo.getId()==id;
		
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
		
	}

	public void updateTodo(@Valid Todo todo) {
		Todo byId = findById(todo.getId());
		byId.setDescription(todo.getDescription());
		byId.setTargetDate(todo.getTargetDate());
		
	}

}
