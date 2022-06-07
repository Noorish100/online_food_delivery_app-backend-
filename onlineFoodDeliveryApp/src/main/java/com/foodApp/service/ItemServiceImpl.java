package com.foodApp.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.foodApp.model.Item;
import com.foodApp.repository.ItemDao;
import com.foodApp.repository.ResturantDao;


@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private ItemDao itemDao;
	
	public ItemServiceImpl() {
		// TODO Auto-generated constructor stub
		System.out.println(itemDao);
	}
	
	@Autowired
	private ResturantDao resturantDao;

	@Override
	public Item addItem(Item i) {
		// TODO Auto-generated method stub
		return itemDao.save(null);
	}

	@Override
	public Item updateItem(Item i) {
		// TODO Auto-generated method stub
		java.util.Optional<Item> optI = itemDao.findById(i.getItemId());
				
		if(optI.isPresent()) {
			
			Item existingItem= optI.get();
			
			return itemDao.save(i);
		}
		return null;
	}
	


	@Override
	public Item removeItem(Item i) {
java.util.Optional<Item> optI = itemDao.findById(i.getItemId());
		
		if(optI.isPresent()) {
			
			Item existingResturant= optI.get();
			
			
			itemDao.delete(existingResturant);
		   
		   return existingResturant;
		}
		return null;
	}

	@Override
	public Item viewItem(Item i) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public List<Item> viewAllItemResturant(Resturant res) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public List<Item> viewAllItemByName(String name) {
//		
//		Resturant n= ra.findByName(name);
//		
//		if(n!=null) {
//			
//			List<Item> il=n.getItemlist();
//			
//			return il;
//		}
//		return null;
//		
//	}
}
	
	
	
	
	
	
	
	
