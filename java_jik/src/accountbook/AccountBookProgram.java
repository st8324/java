package accountbook;

import java.util.List;

import accountbook.service.AccountBookService;
import accountbook.service.AccountBookServiceImp;
import accountbook.service.FileService;
import accountbook.service.FileServiceImp;
import program.Program;

public class AccountBookProgram implements Program {

	List<Item> list;//수입 지출 내역
	
	private AccountBookService accountBookService = new AccountBookServiceImp();
	private FileService fileService = new FileServiceImp();
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printMenu() {
		// TODO Auto-generated method stub

	}

	@Override
	public void runMenu(int menu) {
		// TODO Auto-generated method stub

	}

}
