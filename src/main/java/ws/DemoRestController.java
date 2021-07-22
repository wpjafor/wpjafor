package ws;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dao.AccountDao;
import dao.CustomerDao;
import dao.PaymentDao;
import dbcon.FactoryProvider;
import models.Account;
import models.Customer;
import models.Transactions;


 

@Path("wallet")

public class DemoRestController {
	@GET
	@Path("transaction/{id}/{date}/{currency}")
	public Response findAll(@PathParam("id") int id,@PathParam("date") String date,@PathParam("currency") String curr) {
		try {
			PaymentDao dao = new PaymentDao(FactoryProvider.getFactory());
			//TransactionEntity t = new TransactionEntity(1,1,1,"Deposit",1222.00);
			AccountDao dao1 = new AccountDao(FactoryProvider.getFactory());
			 int accId = dao1.getAccountByCurrency(curr, id).getId();
			List<Transactions> list = dao.getTransactionByCustIdAndDateAndAccount(id,date,accId);
			System.out.println("object recieved");
			//GenericEntity<List<Transactions>> genericEntity = new GenericEntity<List<Transactions>>(dao.getTransactionByCustId(1)){};
					 Gson gson = new GsonBuilder().setPrettyPrinting().create();
					 String json = gson.toJson(list);
			return Response
				      .status(Response.Status.OK)
				      .entity(json)
				      .type(MediaType.APPLICATION_JSON)
				      .build();
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}
	@GET
	@Path("login/{username}/{password}")
	@Produces( MediaType.APPLICATION_JSON )
	public Response checkLogin(@PathParam("username") String username,@PathParam("password") String password) {
		try {
			CustomerDao dao = new CustomerDao(FactoryProvider.getFactory());
			Customer u = dao.getUserByLoginIDAndPassword(username, password);
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			 String json = gson.toJson(u);
			String s;
			
			
		
			  return Response.ok(json).build();
			
			
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}
	@GET
	@Path("accounts/{id}")
	public Response findaccounts(@PathParam("id") int id) {
		try {
			AccountDao dao = new AccountDao(FactoryProvider.getFactory());
			List<Account> list = dao.getAccountByCustId(id);
			System.out.println("object recieved");
			//GenericEntity<List<Transactions>> genericEntity = new GenericEntity<List<Transactions>>(dao.getTransactionByCustId(1)){};
					 Gson gson = new GsonBuilder().setPrettyPrinting().create();
					 String json = gson.toJson(list);
			return Response
				      .status(Response.Status.OK)
				      .entity(json)
				      .type(MediaType.APPLICATION_JSON)
				      .build();
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}
}