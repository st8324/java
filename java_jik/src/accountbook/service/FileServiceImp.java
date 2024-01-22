package accountbook.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import accountbook.model.Item;
import word.Word;

public class FileServiceImp implements FileService {

	@Override
	public List<Item> load(String fileName) {
		try(ObjectInputStream ois = 
			new ObjectInputStream(new FileInputStream(fileName))){
			return (List<Item>) ois.readObject();
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public boolean save(String fileName, List<Item> list) {
		try(ObjectOutputStream oos = 
			new ObjectOutputStream(new FileOutputStream(fileName))){
			oos.writeObject(list);
			return true;
		}catch(Exception e) {
		}
		return false;
	}

}
