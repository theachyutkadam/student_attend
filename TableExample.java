import javax.swing.*;    
public class TableExample {    
  JFrame f;
  JTable table;
  JScrollPane panel;
  TableExample(){    
    f = new JFrame();    
    Object data[][] = { {101,"Amit","670000"},    
                          {"102","Jai","780000"},    
                          {"101","Sachin","700000"}};    
    String column[] = {"ID","NAME","SALARY"};         
    table = new JTable(data,column);    
    table.setBounds(30,40,200,300);          
    panel = new JScrollPane(table);    
    f.add(panel);          
    f.setSize(300,400);
    f.setVisible(true);    
  }     
  public static void main(String[] args) {    
    new TableExample();    
  }    
}  