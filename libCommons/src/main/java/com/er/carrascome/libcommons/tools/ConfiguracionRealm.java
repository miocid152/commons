package com.er.carrascome.libcommons.tools;

import com.er.carrascome.libsecurity.expose.SecurityExpose;
import com.er.carrascome.libsecurity.resource.SecurityConstants;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class ConfiguracionRealm {
    public static byte[] hexkydb;

    public static byte[] getHexkydb() {
        if(ConfiguracionRealm.hexkydb != null && ConfiguracionRealm.hexkydb.length>0){
            return ConfiguracionRealm.hexkydb;
        }
        else {
            ConfiguracionRealm.hexkydb = SecurityExpose.HexStringToByteArray(SecurityConstants.hexky);
            return ConfiguracionRealm.hexkydb;
        }
    }

    public static Realm instanceDBMenu() {
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("chatita.realm")
                .encryptionKey(ConfiguracionRealm.getHexkydb())
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build();

        return Realm.getInstance(config);
    }

    /*
    RealmConfiguration myConfig = new RealmConfiguration.Builder()
  .name("myrealm.realm")
  .schemaVersion(2)
  .modules(new MyCustomSchema())
  .build();

RealmConfiguration otherConfig = new RealmConfiguration.Builder()
  .name("otherrealm.realm")
  .schemaVersion(5)
  .modules(new MyOtherSchema())
  .build();

Realm myRealm = Realm.getInstance(myConfig);
Realm otherRealm = Realm.getInstance(otherConfig);
     */
}
