import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ControlPanel extends JPanel {
    MainFrame mainFrame;
    DesignPanel designPanel;
    JTextField jTextField1 = new JTextField(30);
    JTextField jTextField2 = new JTextField(30);

    JButton jButton = new JButton("add");

    public ControlPanel(MainFrame mainFrame, DesignPanel designPanel) {
        this.mainFrame = mainFrame;
        this.designPanel = designPanel;

        jButton.setBounds(10,10,80,40);
        jTextField1.setBounds(100,20,80,40);
        jTextField1.setSize(30,30);
        jTextField2.setBounds(200,20,80,40);
        jTextField2.setSize(30,30);
        this.add(jButton);
        this.add(jTextField1);
        this.add(jTextField2);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("1");
                try {
                    JComponent jComponent1=create();
                    jComponent1.setVisible(true);
                    System.out.println("------------------------"+jComponent1);
                    designPanel.add(jComponent1);
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                } catch (NoSuchMethodException noSuchMethodException) {
                    noSuchMethodException.printStackTrace();
                } catch (IllegalAccessException illegalAccessException) {
                    illegalAccessException.printStackTrace();
                } catch (InvocationTargetException invocationTargetException) {
                    invocationTargetException.printStackTrace();
                } catch (InstantiationException instantiationException) {
                    instantiationException.printStackTrace();
                }
                System.out.println("2");
                designPanel.revalidate();
                System.out.println("3");
                designPanel.updateUI();
                System.out.println("4");
            }
        });


    }


    private JComponent create() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String comp = "javax.swing." + jTextField1.getText();
        System.out.println("---------------"+comp);

            Class clazz = Class.forName(comp);
            JComponent jComponent =(JComponent) clazz.getConstructor().newInstance();
            System.out.println("+++++++++++++++++++++++"+jComponent);
            if(!(jTextField1.getText().equals("JTree"))&&!(jTextField1.getText().equals("JTextField"))&&!(jTextField1.getText().equals("JFrame"))&&!(jTextField1.getText().equals("JPanel"))){
               setText(clazz,jComponent);
            }
            if(jTextField1.getText().equals("JPanel")){
                jComponent.setBackground(Color.black);
            }

            System.out.println("+++++++++++++++++++++++"+jComponent);
            return jComponent;


    }

    private void setText(Class clazz, JComponent jComponent){
        String continut=jTextField2.getText();
        try{
            Method method =clazz.getMethod("setText",String.class);
            method.invoke(jComponent,continut);
        }catch (NoSuchMethodException e){
            e.printStackTrace();
        }
        catch (IllegalAccessException e){
            e.printStackTrace();
        }
        catch (InvocationTargetException e){
            e.printStackTrace();
        }
        }
    }


