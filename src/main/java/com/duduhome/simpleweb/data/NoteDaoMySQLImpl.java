package com.duduhome.simpleweb.data;

import com.yammer.dropwizard.lifecycle.Managed;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

public class NoteDaoMySQLImpl implements NoteDao, Managed {
    private final String _user;
    private final String _pass;
    private final String _host;
    private final String _dbName;
    private final String _tableName;
    private final ResultSetHandler<List<Note>> _handler;
    private Connection _conn = null;
    private final QueryRunner _runner;

    public NoteDaoMySQLImpl(String user, String pass, String host, String dbName, String tableName) throws ClassNotFoundException {
        _user = user;
        _pass = pass;
        _host = host;
        _dbName = dbName;
        _tableName = tableName;
        _runner = new QueryRunner();
        _handler = new BeanListHandler<Note>(Note.class);
        //check mysql driver
        Class.forName("com.mysql.jdbc.Driver");
    }

    @Override
    public void start() throws Exception {
        try {
            _conn = DriverManager.getConnection(String.format("jdbc:mysql://%s/%s", _host, _dbName), _user, _pass);
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
        }
        checkNotNull(_conn);
    }

    @Override
    public void stop() throws Exception {
        DbUtils.close(_conn);
    }

    private void reconnect() throws SQLException {
        if (_conn == null || !_conn.isValid(0)) {
            _conn = DriverManager.getConnection(String.format("jdbc:mysql://%s/%s", _host, _dbName), _user, _pass);
        }
    }

    @Override
    public void putNote(final Note note) throws Exception {
        if (!_conn.isValid(0)) {
            reconnect();
        }
        _runner.update(_conn, "INSERT INTO " + _tableName + " (author, content) VALUES (?, ?)", note.getAuthor(), note.getContent());
    }

    @Override
    public Note getNoteById(final int id) throws Exception {
        if (!_conn.isValid(0)) {
            reconnect();
        }

        List<Note> result = _runner.query(_conn, "SELECT * FROM " + _tableName + " WHERE id = ?", _handler, id);
        return result.get(0);
    }

    @Override
    public Iterable<Note> queryNoteByAuthor(String author, String orderBy) throws Exception {
        if (!_conn.isValid(0)) {
            reconnect();
        }
        if (orderBy == null) {
            orderBy = "time";
        }
        return _runner.query(_conn, "SELECT * FROM " + _tableName + " WHERE author = ? ORDER BY " + orderBy, _handler, author);
    }

    @Override
    public Iterable<Note> queryNoteByContent(String content, String orderBy) throws Exception {
        if (!_conn.isValid(0)) {
            reconnect();
        }
        if (orderBy == null) {
            orderBy = "time";
        }
        return _runner.query(_conn, "SELECT * FROM " + _tableName + " WHERE content like '%" + content + "%' ORDER BY " + orderBy, _handler);
    }

    @Override
    public Iterable<Note> getAllNotes(String orderBy) throws Exception {
        if (!_conn.isValid(0)) {
            reconnect();
        }
        if (orderBy == null) {
            orderBy = "time";
        }
        return _runner.query(_conn, "SELECT * FROM " + _tableName + " ORDER BY " + orderBy, _handler);
    }

    @Override
    public Iterable<Note> queryNote(NoteQueryRequest request) throws Exception {
        throw new UnsupportedOperationException();
    }
}
