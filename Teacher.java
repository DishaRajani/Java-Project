import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Teacher extends Applet implements ActionListener 
{
    Label lname, lgender, lemail, lcollege, ldept,lseatno,ldob;
    TextField tname,temail,tcollege,tseatno;
    Checkbox m,f;
    CheckboxGroup cg;
    Choice dept,dd,mm,yy;
    Button b1;
    String sname=new String("");
    String sgender =new String("");
    String semail=new String("");
    String scollege=new String("");
    String sdept=new String("");
    String sseatno=new String("");
    String sdob=new String("");
    String sdd=new String("");
    String smm=new String("");
    String syy=new String("");
    
    String sdbname=new String("");
    String scid= new String("");
    String steacher= new String("");
    String spassword = new String("");
    
    public void init() 
    {
        this.setLayout(null);
        this.setSize(600, 400);
        lname = new Label("Name:");
        lgender = new Label("Gender:");
        lemail = new Label("Email address:");
        lcollege = new Label("College");
        ldept = new Label("Dept");
        lseatno=new Label("Seat No");
        ldob=new Label("Date of Birth");
        tname=new TextField();
        temail=new TextField();
        tcollege= new TextField();
        cg=new CheckboxGroup();
        m=new Checkbox("M",cg,false);
        f=new Checkbox("F",cg,false);
        dept=new Choice();
        dd=new Choice();
        mm=new Choice();
        yy=new Choice();
        dept.addItem("COMS");
        dept.addItem("IT");
        dept.addItem("EXTC");
        dept.addItem("INSTRU");
        dept.addItem("MECHANICAL");
        dept.addItem("CIVIL");
        tseatno=new TextField();
        dd.addItem("1");
        dd.addItem("2");
        dd.addItem("3");
        dd.addItem("4");
        dd.addItem("5");
        dd.addItem("6");
        dd.addItem("7");
        dd.addItem("8");
        dd.addItem("9");
        dd.addItem("10");
        dd.addItem("11");
        dd.addItem("12");
        dd.addItem("13");
        dd.addItem("14");
        dd.addItem("15");
        dd.addItem("16");
        dd.addItem("17");
        dd.addItem("18");
        dd.addItem("19");
        dd.addItem("20");
        dd.addItem("21");
        dd.addItem("22");
        dd.addItem("23");
        dd.addItem("24");
        dd.addItem("25");
        dd.addItem("26");
        dd.addItem("27");
        dd.addItem("28");
        dd.addItem("29");
        dd.addItem("30");
        dd.addItem("31");
        mm.addItem("January");
        mm.addItem("Feburary");
        mm.addItem("March");
        mm.addItem("April");
        mm.addItem("May");
        mm.addItem("June");
        mm.addItem("July");
        mm.addItem("August");
        mm.addItem("Semtember");
        mm.addItem("October");
        mm.addItem("Novenber");
        mm.addItem("December");
        yy.addItem("1995");
        yy.addItem("1996");
        yy.addItem("1997");
        yy.addItem("1998");
        yy.addItem("1999");
        yy.addItem("2000");
        yy.addItem("2001");
        yy.addItem("2002");
        yy.addItem("2003");
        yy.addItem("2003");
        yy.addItem("2004");
        yy.addItem("2005");
        yy.addItem("2006");
        yy.addItem("2007");
        yy.addItem("2008");
        yy.addItem("2009");
        yy.addItem("2010");
        yy.addItem("2011");
        yy.addItem("2012");
        yy.addItem("2013");
        yy.addItem("2014");
        yy.addItem("2015");
        yy.addItem("2016");
        yy.addItem("2017");
        
        b1=new Button("OK");
        lname.setBounds(10, 10, 50, 25);
        tname.setBounds(80,10,200,25);
        lgender.setBounds(10,50,50,25);
        m.setBounds(80,50,50,25);
        f.setBounds(140,50,50,25);
        lemail.setBounds(10,90,50,25);
        temail.setBounds(80,90,200,25);
        lcollege.setBounds(10,130,50,25);
        tcollege.setBounds(80,130,200,25);
        ldept.setBounds(10,170,50,25);
        dept.setBounds(80,170,200,25);
        lseatno.setBounds(10, 220, 50, 25);
        tseatno.setBounds(80, 220, 200, 25);
        b1.setBounds(80,320,50,25);
        ldob.setBounds(10,270,80,25);
        dd.setBounds(85,270,40,25);
        mm.setBounds(135,270,70,25);
        yy.setBounds(215,270,60,25);
        add(lname);
        add(tname);
        add(lgender);
        add(m);
        add(f);
        add(lemail);
        add(temail);
        add(lcollege);
        add(tcollege);
        add(ldept);
        add(dept);
        add(b1);
        add(lseatno);
        add(tseatno);
        add(ldob);
        add(dd);
        add(mm);
        add(yy);
        b1.addActionListener(this);
        lgender.setVisible(false);
        m.setVisible(false);
        f.setVisible(false);
        lemail.setVisible(false);
        temail.setVisible(false);
        lcollege.setVisible(false);
        tcollege.setVisible(false);
        ldept.setVisible(false);
        dept.setVisible(false);
        lseatno.setVisible(false);
        tseatno.setVisible(false);
        ldob.setVisible(false);
        dd.setVisible(false);
        mm.setVisible(false);
        yy.setVisible(false);
    }
    public void actionPerformed(ActionEvent ae)
    {
        lgender.setVisible(true);
        m.setVisible(true);
        f.setVisible(true);
        lemail.setVisible(true);
        temail.setVisible(true);
        lcollege.setVisible(true);
        tcollege.setVisible(true);
        ldept.setVisible(true);
        dept.setVisible(true);
        lseatno.setVisible(true);
        tseatno.setVisible(true);
        ldob.setVisible(true);
        dd.setVisible(true);
        mm.setVisible(true);
        yy.setVisible(true);
        sname=tname.getText();
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            Connection con =DriverManager.getConnection("jdbc:derby://localhost:1527/chirag;create=true;user=cw121;password=chinuchinu");    
            Statement st=con.createStatement();
            String query="select * from STUDENT_INFORMATION";
            ResultSet rs= st.executeQuery(query);
            while(rs.next())
            {
                sdbname=(rs.getString("NAME"));
                if(sname.equalsIgnoreCase(sdbname))
                {
                    if(("m".equals(rs.getString("GENDER")))||"M".equals(rs.getString("GENDER")))
                        cg.setSelectedCheckbox(m);
                    else
                        cg.setSelectedCheckbox(f);
                    temail.setText(rs.getString("EMAIL"));
                    tcollege.setText(rs.getString("COLLEGE"));
                    dept.select(rs.getString("DEPT"));
                    tseatno.setText(rs.getString("SEAT_NO"));
                    dd.select(rs.getString("DATE"));
                    mm.select(rs.getString("MONTH"));
                    yy.select(rs.getString("YEAR_"));
                }
            }
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (ClassNotFoundException ex) 
        {
            Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) 
        {
            Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) 
        {
            Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}