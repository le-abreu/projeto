package br.com.autoescola.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.ServletContext;

public class ControllerArquivo {

	public static void guardarArquivo(InputStream arquivoUpdate, String path, String nomeArquivo) {
		
		String newFileName = ControllerArquivo.criarArquivo(path, nomeArquivo);
		FileImageOutputStream imageOutput;
		
		try {
			int read = 0;
			byte[] bytes = new byte[1024];
			imageOutput = new FileImageOutputStream(new File(newFileName)); 
			while ((read = arquivoUpdate.read(bytes)) != -1) {
				imageOutput.write(bytes, 0, read);
			}
			arquivoUpdate.close(); 
			imageOutput.close();
		} catch (Exception e) {
			throw new FacesException("Error in writing captured image.");
		}
	}

	public static void guardarArquivo(byte[] data, String path, String nomeArquivo) {
		String newFileName = ControllerArquivo.criarArquivo(path, nomeArquivo);
		FileImageOutputStream out;
		try {
			out = new FileImageOutputStream(new File(newFileName));
			out.write(data);
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String criarArquivo(String path, String nomeArquivo) {
		ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();  
		String pathComplete = servletContext.getRealPath("") + File.separator + path;
//		String pathComplete = path;
		
		File file = new File(pathComplete);
		file.isFile();
		file.mkdirs();
		if(nomeArquivo != null){
			pathComplete = servletContext.getRealPath("") + File.separator + path + File.separator + nomeArquivo;
			file = new File( pathComplete );
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return pathComplete;
	}
	
	
	public static void guardarArquivo_(InputStream arquivoUpdate, String path, String nomeArquivo) {
		try {
			File file = new File("\\"+path);
			file.isFile();
			file.mkdirs();
			file = new File("\\"+path + nomeArquivo);
			file.createNewFile();
			OutputStream out = new FileOutputStream(file);
			int read = 0;
			byte[] bytes = new byte[1024];
			while ((read = arquivoUpdate.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			arquivoUpdate.close(); 
			out.flush();
			out.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static InputStream getArquivo(String string) {
		File file = new File(string);
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(file);
			file.delete();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return fileInputStream;
	}

	public static void apagarArquivosPasta(File f) {
		if (f.isDirectory()) {
			File[] files = f.listFiles();
			for (File file : files) {
				file.delete();
			}
			f.delete();
		}
	}

	public static String criarArquivo(String path) {
		return criarArquivo(path, null);
	}
}
