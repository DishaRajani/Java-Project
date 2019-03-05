import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class NewApplet extends Applet implements ActionListener 
{
    private Button bTeacher = new Button("Teacher");
    private Button bStudent = new Button("Student");
    
    public void init() 
    {
        this.setLayout(null);
        this.setBackground(Color.blue);
        this.resize(800, 500);
        bTeacher.setBounds(200,250,100,50);
        bStudent.setBounds(400,250,100,50);
        add(bTeacher);
        add(bStudent);
        bTeacher.addActionListener( this);
        bStudent.addActionListener(this);   
    }

    // TODO overwrite start(), stop() and destroy() methods
    public void actionPerformed(ActionEvent ae) 
    {

        bTeacher.setVisible(false);
        bStudent.setVisible(false);
        if(ae.getSource()==bTeacher)
        {
            teacherForm();
        }
        else if (ae.getSource()==bStudent)
        {
            studentForm();
        }
    }
     void studentForm()
    {
        Student s1= new Student();
        s1.setBounds(50, 50, 600 ,400);
        s1.init();
        add(s1);
    }
     void teacherForm()
     {
         Teacher t1 = new Teacher();
         t1.setBounds(50, 50, 600,400);
         t1.init();
         add(t1);
     }
}