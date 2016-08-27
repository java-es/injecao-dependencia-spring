package javaes.wordpress.com.domain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javaes.wordpress.com.domain.dao.ContactDAO;

/**
 * @author https://javaes.wordpress.com/
 *
 */
@Component
public class ContactService implements IService {
	@Autowired
	private ContactDAO dao;

	// Lista todos os contatos do banco de dados
	public List<Contact> getContacts() {
		try {
			List<Contact> contacts = this.dao.getContacts();
			return contacts;
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<Contact>();
		}
	}

	// Busca um contato pelo id
	public Contact getContact(Long id) {
		try {
			return this.dao.getContactById(id);
		} catch (SQLException e) {
			return null;
		}
	}

	// Deleta o contato pelo id
	public boolean delete(Long id) {
		try {
			return this.dao.delete(id);
		} catch (SQLException e) {
			return false;
		}
	}

	// Salva ou atualiza o contato
	public boolean save(Contact contact) {
		try {
			this.dao.save(contact);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	// Busca o contato pelo nome
	public List<Contact> findByName(String name) {
		try {
			return this.dao.findByName(name);
		} catch (SQLException e) {
			return null;
		}
	}
}
