package org.example.uc16;

import java.util.logging.Logger;

public class Repository {
    private static final Logger logger =
            Logger.getLogger(Repository.class.getName());

    private static Repository instance;

    private ConnectionPool connectionPool;

    private Repository() {
        connectionPool = ConnectionPool.getInstance();
    }

    public static synchronized Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }

    public String getPoolStatistics() {
        try {
            return connectionPool.getPoolStats();
        } catch (Exception e) {
            logger.severe("Error fetching pool stats: " + e.getMessage());
            throw new DatabaseException("Failed to fetch pool stats", e);
        }
    }
}
