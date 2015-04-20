package com.cloudview.lib;

import java.sql.Array;

import com.cloudview.dao.AppUserRepository;
import com.cloudview.model.AppUser;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(RandomPasswordGene.Generate(9, 15));
        AppUserRepository userRep = new AppUserRepository();
        AppUser user = new AppUser();
        user.setLogin("sinayoko.mahamadou@yahoo.fr");
        user.setPassword(RandomPasswordGene.Generate(9, 15));
        userRep.save(user);
	}

}
