import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import java.util.*;

class Voter
{
    String name;
    String phone;
    boolean voted;
    boolean added;
    Voter(String n,String p)
    {
        name=n;
        phone=p;
        voted=false;
        added=false;
    }
}
class Candidate extends Voter
{
    String party;
    int con;
    Candidate(String n,String ph,String p,int c)
    {
        super(n,ph);
        party=p;
        con=c;
    }
}

class Constituency
{
    
    ArrayList<Candidate> candidates;
    ArrayList<Voter> voters;
    int cparty[]={0,0,0};

    Constituency()
    {
        candidates=new ArrayList<Candidate>(3);
        voters=new ArrayList<Voter>();
    }
}
class Election 
{
    int tparty[]={0,0,0};
    Constituency clist[]=new Constituency[2];
    {clist[0]=new Constituency();
    clist[1]=new Constituency();}
    Election()
    {
        JFrame f=new JFrame();

        JButton c1=new JButton("Constituency 1");
        JButton c2=new JButton("Constituency 2");
        JButton results=new JButton("Election Results");

        f.add(c1);
        f.add(c2);
        f.add(results);
        
        //c1.setBackground(new Color(0, 0, 0));

        c1.setBounds(50,10,400,50);
        c2.setBounds(50,70,400,50);
        results.setBounds(50,130,400,50);

        c1.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    conelec(clist[0],1);
                }
            }
        );
        c2.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    conelec(clist[1],2);
                }
            }
        );
        results.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                   String res="Elecion Results\n";
                   res+="Party A ="+tparty[0]+"\n";
                   res+="Party B ="+tparty[1]+"\n";
                   res+="Party C ="+tparty[2]+"\n";
                   res+="Total votes="+(tparty[0]+tparty[1]+tparty[2])+"\n";
                   String lead=(tparty[0]>tparty[1])?(tparty[0]>tparty[2])?"A":"C":(tparty[1]>tparty[2])?"B":"C";
                   res+="Leading party ="+lead;
                   JOptionPane.showMessageDialog(f,res);

                }
            }
        );

        f.setLayout(null);
        f.setSize(500, 300);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    void conelec(Constituency con,int no)
    {
        JFrame f=new JFrame("Constituency"+Integer.toString(no));

        JButton canreg=new JButton("Candiadate registration");
        JButton votreg=new JButton("Voter registration");
        JButton voting=new JButton("Voting");
        JButton condet=new JButton("Constituency Details");
        JButton results=new JButton("Results at constitution level");
        JButton exit=new JButton("EXIT");
        
        f.add(canreg);
        f.add(votreg);
        f.add(voting);
        f.add(condet);
        f.add(results);
        f.add(exit);

        canreg.setBounds(50,10,400,50);
        votreg.setBounds(50,70,400,50);
        voting.setBounds(50,130,400,50);
        condet.setBounds(50,190,400,50);
        results.setBounds(50,250,400,50);
        exit.setBounds(50,310,400,50);

        canreg.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    //con.candidates.add(candReg());
                    candReg(con,no);
                }
            }
        );
        
        votreg.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    //con.candidates.add(candReg());
                    voterReg(con);
                }
            }
        );

        condet.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    String det="Constituency-"+no+"\n";
                    int canlen=con.candidates.size();
                    int votrlen=con.voters.size();
                    det+="No.of.can-"+canlen+"\n";
                    det+="No.of.votrs-"+votrlen;
                    JOptionPane.showMessageDialog(f,det);
                }

            }
        );

        voting.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                   voting(con, no);;
                }
            }
        );

        results.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                   String res="constituition-"+no+"\n";
                   res+="Party A ="+con.cparty[0]+"\n";
                   res+="Party B ="+con.cparty[1]+"\n";
                   res+="Party C ="+con.cparty[2]+"\n";
                   res+="Total votes="+(con.cparty[0]+con.cparty[1]+con.cparty[2]);
                   String lead=(con.cparty[0]>con.cparty[1])?(con.cparty[0]>con.cparty[2])?"A":"C":(con.cparty[1]>con.cparty[2])?"B":"C";
                   res+="Leading party ="+lead;
                   JOptionPane.showMessageDialog(f,res);

                }
            }
        );

        exit.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                   f.setVisible(false);
                }
            }
        );

        f.setLayout(null);
        f.setSize(500, 500);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    void candReg(Constituency con,int no)
    {
        Candidate cn=null;
        JFrame crf= new JFrame("Candidate Registration");
        crf.setLayout(null);
        crf.setSize(300,300);
        crf.setVisible(true);

        JLabel ename=new JLabel("Name");
        JTextField tfname=new JTextField(10);
        JLabel enumb=new JLabel("Number");
        JTextField tfnum=new JTextField(10);
        JRadioButton p1=new JRadioButton("Party A");
        JRadioButton p2=new JRadioButton("Party B");
        JRadioButton p3=new JRadioButton("Party C");
        JButton reg=new JButton("Register");

        crf.add(ename);
        crf.add(tfname);
        crf.add(enumb);
        crf.add(tfnum);
        crf.add(p1);
        crf.add(p2);
        crf.add(p3);
        crf.add(reg);

        ButtonGroup bg=new ButtonGroup();
        bg.add(p1);
        bg.add(p2);
        bg.add(p3);

        ename.setBounds(10,10,150,30);
        tfname.setBounds(80,10,200,30);
        enumb.setBounds(10,50,150,30);
        tfnum.setBounds(80,50,200,30);
        p1.setBounds(10,90,80,30);
        p2.setBounds(110,90,80,30);
        p3.setBounds(210,90,80,30);
        reg.setBounds(80,130,200,30);
        
        reg.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    Candidate cn=null;
                    String name=tfname.getText();
                    String numb=tfnum.getText();
                    if(p1.isSelected())
                    {
                        boolean filled=false;
                        Candidate x=null;
                        for(Candidate c:con.candidates)
                        {
                            if(c.party.equals("A"))
                            {
                                filled=true;
                                x=c;
                            }
                        }
                        if(filled)
                        {
                            JOptionPane.showMessageDialog(crf,"Party was filled with can-"+x.name);
                        }
                        else
                        {
                            cn=new Candidate(name,numb,"A",no);
                            //done=true;
                            con.candidates.add(cn);
                            boolean legi=true;
                            for(Voter v:con.voters)
                            {
                                if(v.name.equals(name) && v.phone.equals(numb) && v.added==true)
                                {
                                    legi=false;
                                }       
                            }
                            if(legi)
                            {
                                System.out.println(con.voters.add(new Voter(name, numb)));
                            }
                            JOptionPane.showMessageDialog(crf,"Successfull registered");
                            crf.setVisible(false);
                        }
                    }
                    if(p2.isSelected())
                    {
                        boolean filled=false;
                        Candidate x=null;
                        for(Candidate c:con.candidates)
                        {
                            if(c.party.equals("B"))
                            {
                                filled=true;
                                x=c;
                            }
                        }
                        if(filled)
                        {
                            JOptionPane.showMessageDialog(crf,"Party was filled with can-"+x.name);
                        }
                        else
                        {
                            cn=new Candidate(name,numb,"B",no);
                            //done=true;
                            con.candidates.add(cn);
                            boolean legi=true;
                            for(Voter v:con.voters)
                            {
                                if(v.name.equals(name) && v.phone.equals(numb) && v.added==true)
                                {
                                    legi=false;
                                }       
                            }
                            if(legi)
                            {
                                System.out.println(con.voters.add(new Voter(name, numb)));
                            }
                            JOptionPane.showMessageDialog(crf,"Successfull registered");
                            crf.setVisible(false);
                        }
                    }
                    if(p3.isSelected())
                    {
                        boolean filled=false;
                        Candidate x=null;
                        for(Candidate c:con.candidates)
                        {
                            if(c.party.equals("C"))
                            {
                                filled=true;
                                x=c;
                            }
                        }
                        if(filled)
                        {
                            JOptionPane.showMessageDialog(crf,"Party was filled with can-"+x.name);
                        }
                        else
                        {
                            cn=new Candidate(name,numb,"C",no);
                            con.candidates.add(cn);
                            boolean legi=true;
                            for(Voter v:con.voters)
                            {
                                //System.out.println(name+"-"+v.name+"^"+numb+"-"+v.phone);
                                if(v.name.equals(name) && v.phone.equals(numb) && v.added==true)
                                {
                                    legi=false;
                                }       
                            }
                            if(legi)
                            {
                                System.out.println(con.voters.add(new Voter(name, numb)));
                            }
                            JOptionPane.showMessageDialog(crf,"Successfull registered");
                            crf.setVisible(false);
                        }
                    }               
                }
            }
        );
        
    }
    void voterReg(Constituency con)
    {
        JFrame vrf= new JFrame("Voter Registration");
        vrf.setLayout(null);
        vrf.setSize(300,300);
        vrf.setVisible(true);

        JLabel ename=new JLabel("Name");
        JTextField tfname=new JTextField(10);
        JLabel enumb=new JLabel("Number");
        JTextField tfnum=new JTextField(10);
        JButton reg=new JButton("Register");

        ename.setBounds(10,10,150,30);
        tfname.setBounds(80,10,200,30);
        enumb.setBounds(10,50,150,30);
        tfnum.setBounds(80,50,200,30);
        reg.setBounds(80,90,200,30);

        vrf.add(ename);
        vrf.add(tfname);
        vrf.add(enumb);
        vrf.add(tfnum);
        vrf.add(reg);

        reg.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    String n=tfname.getText();
                    String nu=tfnum.getText();
                    boolean legi=true;
                    for(Voter v:con.voters)
                    {
                        if(v.name.equals(n) && v.phone.equals(nu))
                        {
                            legi=false;
                        }
                    }
                    if(legi)
                    {
                        Voter v=new Voter(n, nu);
                        v.added=true;
                        con.voters.add(v);
                        System.out.println(v.name+v.phone);
                        JOptionPane.showMessageDialog(vrf,"Successfull registered");
                        vrf.setVisible(false);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(vrf,"Voter details already registered");
                        vrf.setVisible(false);
                    }
                }
            }
        );
    }
    void voting(Constituency con,int no)
    {
        JFrame f=new JFrame("Constituency"+Integer.toString(no));
        f.setLayout(null);
        f.setSize(300, 500);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.setVisible(true);

        JLabel ename=new JLabel("Name");
        JTextField tfname=new JTextField(10);
        JLabel enumb=new JLabel("Number");
        JTextField tfnum=new JTextField(10);
        JButton vote=new JButton("Vote");
        
        String ca="",cb="",cc="";
        for(Candidate c:con.candidates)
        {
            if(c.party.equals("A"))
                ca=c.name;
        }
        for(Candidate c:con.candidates)
        {
            if(c.party.equals("B"))
                cb=c.name;
        }
        for(Candidate c:con.candidates)
        {
            if(c.party.equals("C"))
                cc=c.name;
        }

        JRadioButton p1=new JRadioButton("A->"+ca);
        JRadioButton p2=new JRadioButton("B->"+cb);
        JRadioButton p3=new JRadioButton("C->"+cc);

        ButtonGroup bg=new ButtonGroup();
        bg.add(p1);
        bg.add(p2);
        bg.add(p3);
        
        f.add(ename);
        f.add(tfname);
        f.add(enumb);
        f.add(tfnum);
        f.add(p1);
        f.add(p2);
        f.add(p3);
        f.add(vote);

        ename.setBounds(10,10,150,30);
        tfname.setBounds(80,10,200,30);
        enumb.setBounds(10,50,150,30);
        tfnum.setBounds(80,50,200,30);
        p1.setBounds(80,90,250,30);
        p2.setBounds(80,130,250,30);
        p3.setBounds(80,170,250,30);
        vote.setBounds(80,210,200,30);

        vote.addActionListener(
            new ActionListener() 
            {
                public void actionPerformed(ActionEvent e)
                {
                    String name=tfname.getText();
                    String numb=tfnum.getText();
                    boolean legi=false;
                    for(Voter v:con.voters)
                    {
                        if(v.name.equals(name) && v.phone.equals(numb) && v.voted==false)
                        {
                            legi=true;
                            v.voted=true;
                        }       
                    }
                    if(legi)
                    {
                        if(p1.isSelected())
                        {
                            tparty[0]++;
                            con.cparty[0]++;
                        }
                        if(p2.isSelected())
                        {
                            tparty[1]++;
                            con.cparty[1]++;
                        }
                        if(p3.isSelected())
                        {
                            tparty[2]++;
                            con.cparty[2]++;
                        }
                        JOptionPane.showMessageDialog(f,"Successfull Voted");
                        f.setVisible(false);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(f,"Voter not registered or already voted","Alert",JOptionPane.WARNING_MESSAGE);
                        f.setVisible(false);
                    }
                }
            }
        );

    }
}

public class VotingSystem
{
    public static void main(String[] args) {
        Election e=new Election();
    }
}
