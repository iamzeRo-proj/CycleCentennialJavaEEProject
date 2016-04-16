package com.service;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class CAPTCHAServlet
 */
@WebServlet("/CAPTCHAServlet")
public class CAPTCHAServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 120;
	public static final int HEIGHT = 25;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CAPTCHAServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		
		Graphics g = image.getGraphics();
		
		setBackGround(g);
		
		setBorder(g);
		
		drawRandomLine(g);
		
		String checkCode = drawRandomNumber((Graphics2D)g);
		request.getSession().setAttribute("checkCode", checkCode);
		
		response.setContentType("image/jpeg");
		response.setDateHeader("expries", -1);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		ImageIO.write(image, "jpg", response.getOutputStream());
	}

	private String drawRandomNumber(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.setFont(new Font("TimesRoman", Font.BOLD, 20));
		
		String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		
		StringBuffer sb = new StringBuffer();
		int x = 10;		
		for(int i=0;i<4;i++){			
			int degree = new Random().nextInt()%30;
			g.rotate(degree*Math.PI/180,x,20);
			String ch = base.charAt(new Random().nextInt(base.length()))+"";
			sb.append(ch);
			g.drawString(ch, x, 20);
			g.rotate(-degree*Math.PI/180,x,20);
			x+=30;
		}
		return sb.toString();
	}

	private void drawRandomLine(Graphics g) {
		g.setColor(Color.GREEN);
		
		for(int i=0; i<5; i++){
			int x1 = new Random().nextInt(WIDTH);
			int y1 = new Random().nextInt(HEIGHT);
			
			int x2 = new Random().nextInt(WIDTH);
			int y2 = new Random().nextInt(HEIGHT);
			g.drawLine(x1, y1, x2, y2);			
		}		
		
	}

	private void setBorder(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawRect(1, 1, WIDTH-2, HEIGHT-2);
		
	}

	private void setBackGround(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
