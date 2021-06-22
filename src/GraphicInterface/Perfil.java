package GraphicInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Files.UserUtiles;
import types_users.Client;
import types_users.Users;

public class Perfil extends JFrame implements ActionListener{

	private JPanel panelInfo, panelBtn;
	private Users user;
	private JButton btnBack, btnChangeA, btnChangeC, btnChangeM, btnChangeL, btnChangeP, btnAddCard;
	private JLabel lName, lLastName, lMail, lAddress, lCity, lCreditCard, lBalance, lInfo, lInfo2; 
	
	private Color panelColor = new Color(100, 170, 255);
	private final static int width = 1000;
	private final static int height = 600;
	
	public Perfil(Users user)
	{
		
		this.setLayout(null);
		this.setTitle("Principal");
		this.setSize(width, height);
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// USER
		
		this.user = user;
		
		// PANELS
		
		panelInfo = new JPanel();
		panelInfo.setLayout(null);
		panelInfo.setBounds(50, 70, 400, 400);
		panelInfo.setBackground(panelColor);
		this.add(panelInfo);	
		
		panelBtn = new JPanel();
		panelBtn.setLayout(null);
		panelBtn.setBounds(520, 70, 400, 400);
		panelBtn.setBackground(panelColor);
		this.add(panelBtn);	
		
		// LABELS
		
		lName = new JLabel("Usuario: " + user.getName());
		lName.setBounds(10, 10, 400, 30);
		lName.setFont(new Font(null, 1, 20));
		panelInfo.add(lName);
		
		lLastName = new JLabel("Nombre y apellido: " + user.getName_lastName());
		lLastName.setBounds(10, 50, 400, 30);
		lLastName.setFont(new Font(null, 1, 20));
		panelInfo.add(lLastName);
		
		lMail = new JLabel("Email: " + user.getEmail());
		lMail.setBounds(10, 90, 400, 30);
		lMail.setFont(new Font(null, 1, 20));
		panelInfo.add(lMail);
		
		if(user instanceof Client)
		{
			Client client = (Client) user;
					
			lCity = new JLabel("Ciudad: " + client.getCity());
			lCity.setBounds(10, 130, 400, 30);
			lCity.setFont(new Font(null, 1, 20));
			panelInfo.add(lCity);
			
			lAddress = new JLabel("Direccion: " + client.getAddress());
			lAddress.setBounds(10, 170, 400, 30);
			lAddress.setFont(new Font(null, 1, 20));
			panelInfo.add(lAddress);
			
			lCreditCard = new JLabel("Tarjeta: " + client.getCard().getNumber());
			lCreditCard.setBounds(10, 210, 400, 30);
			lCreditCard.setFont(new Font(null, 1, 20));
			panelInfo.add(lCreditCard);
			
			lBalance = new JLabel("Saldo: $" + client.getCard().getBalance());
			lBalance.setBounds(10, 250, 400, 30);
			lBalance.setFont(new Font(null, 1, 20));
			
			lInfo = new JLabel("(Si modifica sus datos debera iniciar");
			lInfo.setBounds(10, 290, 400, 30);
			lInfo.setFont(new Font(null, Font.BOLD, 18));
			panelInfo.add(lInfo);
			
			lInfo2 = new JLabel("sesion devuelta para que se cambien!)");
			lInfo2.setBounds(10, 310, 400, 30);
			lInfo2.setFont(new Font(null, Font.BOLD, 18));
			panelInfo.add(lInfo2);
			
			
			// BUTTONS
			
			btnChangeP = new JButton("Cambiar contrase�a");
			btnChangeP.setBounds(30, 50, 150, 40);
			btnChangeP.addActionListener(this);
			panelBtn.add(btnChangeP);
			
			btnChangeL = new JButton("Cambiar apellido");
			btnChangeL.setBounds(200, 50, 150, 40);
			btnChangeL.addActionListener(this);
			panelBtn.add(btnChangeL);
			
			btnChangeM = new JButton("Cambiar email");
			btnChangeM.setBounds(30, 120, 150, 40);
			btnChangeM.addActionListener(this);
			panelBtn.add(btnChangeM);
			
			btnChangeC = new JButton("Cambiar ciudad");
			btnChangeC.setBounds(200, 120, 150, 40);
			btnChangeC.addActionListener(this);
			panelBtn.add(btnChangeC);
			
			btnChangeA = new JButton("Cambiar direccion");
			btnChangeA.setBounds(30, 190, 150, 40);
			btnChangeA.addActionListener(this);
			panelBtn.add(btnChangeA);
			
			btnAddCard = new JButton("Agregar tarjeta");
			btnAddCard.setBounds(200, 190, 150, 40);
			btnAddCard.addActionListener(this);
			panelBtn.add(btnAddCard);
			
			btnBack = new JButton("Volver");
			btnBack.setBounds(115, 280, 150, 35);
			btnBack.addActionListener(this);
			panelBtn.add(btnBack);
			panelInfo.add(lBalance);
		}
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnBack)
		{
			Principal principal = new Principal(user);
			this.setVisible(false);
		}
		else if(e.getSource() == btnChangeP)
		{
			String password = JOptionPane.showInputDialog(this, "Ingrese la nuevo contrase�a: "); 
			changePassword(password);
		}
		else if(e.getSource() == btnChangeL)
		{
			String name_lastName = JOptionPane.showInputDialog(this, "Ingrese su nuevo nombre y apellido: "); 
			changeName_lastName(name_lastName);
		}
		else if(e.getSource() == btnChangeA)
		{
			String address = JOptionPane.showInputDialog(this, "Ingrese su nueva direccion: "); 
			changeAddress(address);
		}
		else if(e.getSource() == btnChangeC)
		{
			String city = JOptionPane.showInputDialog(this, "Ingrese la nueva ciudad: "); 
			changeCity(city);
		}
		else if(e.getSource() == btnChangeM)
		{
			String email = JOptionPane.showInputDialog(this, "Ingrese el nuevo email: "); 
			changeMail(email);
		}
		else if(e.getSource() == btnAddCard)
		{
			try {
				String name = JOptionPane.showInputDialog(this, "Ingrese el nombre de la tarjeta: "); 
				String number = JOptionPane.showInputDialog(this, "Ingrese el numero: "); 
				String dueDate = JOptionPane.showInputDialog(this, "Ingrese fecha de vencimiento: (dd/mm/aa)"); 
				int code = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el codigo de seguridad: ")); 
				float balance = Float.parseFloat(JOptionPane.showInputDialog(this, "Ingrese el saldo: ")); 
				addCredirCard(name, number, dueDate, code, balance);	
			} catch (NumberFormatException nfe) {
				
			}
			
		}
	}
	
	public void changePassword(String newPassword)
	{
		HashMap<Integer, Users> hashMap = UserUtiles.read();
		Iterator<Entry<Integer, Users>> it = hashMap.entrySet().iterator();
		
		while(it.hasNext())
		{
			Entry<Integer, Users> entry = it.next();
			if(entry.getKey() == user.getId())
			{
				entry.getValue().setPassword(newPassword);
				UserUtiles.write(entry.getValue());
			}
		}
	}
	
	public void changeName_lastName(String Name_lastName)
	{
		HashMap<Integer, Users> hashMap = UserUtiles.read();
		Iterator<Entry<Integer, Users>> it = hashMap.entrySet().iterator();
		
		while(it.hasNext())
		{
			Entry<Integer, Users> entry = it.next();
			if(entry.getKey() == user.getId())
			{
				entry.getValue().setName_lastName(Name_lastName);
				UserUtiles.write(entry.getValue());
			}
		}
	}

	public void changeAddress(String newAddress)
	{
		HashMap<Integer, Users> hashMap = UserUtiles.read();
		Iterator<Entry<Integer, Users>> it = hashMap.entrySet().iterator();
		Client client;
		
		while(it.hasNext())
		{
			Entry<Integer, Users> entry = it.next();
			if(entry.getKey() == user.getId())
			{
				client = (Client) entry.getValue();
				client.setAddress(newAddress);
				UserUtiles.write(client);
			}
		}
	}
	
	public void changeCity(String newCity)
	{
		HashMap<Integer, Users> hashMap = UserUtiles.read();
		Iterator<Entry<Integer, Users>> it = hashMap.entrySet().iterator();
		Client client;
		
		while(it.hasNext())
		{
			Entry<Integer, Users> entry = it.next();
			if(entry.getKey() == user.getId())
			{
				client = (Client) entry.getValue();
				client.setCity(newCity);
				UserUtiles.write(client);
			}
		}
	}
	
	public void changeMail(String newMail)
	{
		HashMap<Integer, Users> hashMap = UserUtiles.read();
		Iterator<Entry<Integer, Users>> it = hashMap.entrySet().iterator();
		Client client;
		
		while(it.hasNext())
		{
			Entry<Integer, Users> entry = it.next();
			if(entry.getKey() == user.getId())
			{
				client = (Client) entry.getValue();
				client.setEmail(newMail);
				UserUtiles.write(client);
			}
		}
	}
	
	public void addCredirCard(String name, String number, String dueDate, int segurityCode, float balance)
	{
		HashMap<Integer, Users> hashMap = UserUtiles.read();
		Iterator<Entry<Integer, Users>> it = hashMap.entrySet().iterator();
		Client client;
		
		while(it.hasNext())
		{
			Entry<Integer, Users> entry = it.next();
			if(entry.getKey() == user.getId())
			{
				client = (Client) entry.getValue();
				client.enterCard(name, number, dueDate, segurityCode, balance);
				UserUtiles.write(client);
			}
		}
	}

	
}









































