package net.competition.dal;

import net.competition.assets.App;

/**
 * Created by Korisnik on 7/24/2015.
 */
public class DALProvider {

    private static DAO dao;

    public static DAO getDAO() {
        if (dao == null) {
            dao = new SQLiteDAO(App.getContext());
        }
        return dao;
    }
}
