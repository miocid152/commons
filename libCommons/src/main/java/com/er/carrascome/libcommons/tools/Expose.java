package com.er.carrascome.libcommons.tools;

import io.realm.Realm;

public class Expose {

   public static Realm getDBInstanceMenu() {
       return ConfiguracionRealm.instanceDBMenu();
   }
}
