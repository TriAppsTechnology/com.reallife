package com.reallife.test;
import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Location;
import facebook4j.ResponseList;
import facebook4j.conf.ConfigurationBuilder;


@Path("/v1/test")
public class UpdateTest {

	
	@GET
	@Path("{time}")
	@Produces(MediaType.TEXT_HTML)
	public String updateFaceStatus(@PathParam("time") int time) throws FacebookException{
		// Update the facebook status
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		  .setOAuthAppId("277156979159932")
		  .setOAuthAppSecret("317306841d45bcbce9179780c9e2522c")
		  .setOAuthAccessToken("CAACEdEose0cBAHXkYPlFnPkASietvenIDDaOkenjhKiliMwm5vU7A1BRAhZBdF7bXh2bq2SeB4LZBusPlZCIRWV64yE9yDt8NdJNCJ7sud0buGOu5MsrRg51L0Nypq83v63taVr7nQNu8x1D6ZC6Ji36MtuKOwCM8lzKZCD41H8WpkUZARlvHTrUKK2OJy1ZA4rlfQqqvIl53U0IiHZAC8ZCkGbOA1pQ28EUZD")
		  .setOAuthPermissions("publish_actions,user_about_me,user_location");
		FacebookFactory ff = new FacebookFactory(cb.build());
		Facebook facebook = ff.getInstance();

		Calendar c = Calendar.getInstance();
		java.sql.Timestamp t = new java.sql.Timestamp(c.getTime().getTime());
		String a = "ok new message." + t.toString();
		facebook.postStatusMessage(a);
		
		return "Successful:";
	}
}
