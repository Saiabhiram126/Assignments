package com.example.grade;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
public class MultiStudentGradeManager 
{
  Map<String,StudentGradeCalculator> studmap= new HashMap<>();
  public void addStudent(String name)
  {
   if(studmap.containsKey(name))
   {  throw new IllegalArgumentException("Student Name Already Exist..");
   }
   studmap.put(name,new StudentGradeCalculator());
  }

  public void addMarks(String name, int marks)
  {
    StudentGradeCalculator ref= studmap.get(name);
    if(ref==null)
    {
      throw new IllegalArgumentException("Student Not Found...");
    }
    ref.addMarks(marks);
  }
  public double calculateAverage(String name)
  {
   StudentGradeCalculator ref= studmap.get(name);
   if(ref==null)
      {
        throw new IllegalArgumentException("Student Not Found...");
      }  
   return ref.calculateAverage(); 
  }
  public String getResult(String name)
  {
   StudentGradeCalculator ref= studmap.get(name);
    if(ref==null)
   {
      throw new IllegalArgumentException("Student Not Found...");
   }  
  return ref.getResult();
  }

  public String getTopper()
  {
    if(studmap.isEmpty())
    {
      throw new IllegalStateException("No Student Found ");
    }
    return studmap.entrySet().stream().
    max(Comparator.comparingDouble(e->e.getValue().calculateAverage())).get().getKey();
  }      
}