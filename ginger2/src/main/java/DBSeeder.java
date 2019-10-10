import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.repository.UserPostRepository;
import com.example.demo.repository.UserRepository;
@Component
public class DBSeeder implements CommandLineRunner{
	
	private UserRepository ur;
	public DBSeeder(UserRepository ur) {
		this.ur = ur;
	}
	
	@Override
	public void run(String...strings) throws Exception{
		
	}
	
	

}
