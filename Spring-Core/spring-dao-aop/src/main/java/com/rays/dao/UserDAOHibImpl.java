package com.rays.dao;

 
 
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.rays.dto.UserDTO;

@Repository
public class UserDAOHibImpl implements UserDAOInt {

		
		@Autowired
		private SessionFactory sessionFactory = null;

		public long add(UserDTO dto)  throws DataAccessException{
			long pk = (Long) sessionFactory.getCurrentSession().save(dto);
			return pk;
		}

		public void update(UserDTO dto)throws DataAccessException {
			sessionFactory.getCurrentSession().update(dto);
			
		}
		public UserDTO findByPK(long pk)throws DataAccessException  {
			UserDTO dto = null;
			dto = (UserDTO) sessionFactory.getCurrentSession().get(UserDTO.class, pk);
			return dto;
		 
		}
		
		public UserDTO delete(long id)throws DataAccessException {
			UserDTO dto = findByPK(id);
			sessionFactory.getCurrentSession().delete(dto);
			return dto;

	}

		public UserDTO findByLogin(String login) {
			List list = null;
			UserDTO dto = null;
			
			Session session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(UserDTO.class);
			criteria.add(Restrictions.eq("login", login));
			list = criteria.list();
			
			if(list.size() == 1) {
				dto = (UserDTO) list.get(0);
			}
			return dto;
		}

		public UserDTO authenticate(String login, String password) {
			List list = null;
			UserDTO dto = null;
			Session session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(UserDTO.class);
			criteria.add(Restrictions.eq("login", login));
			criteria.add(Restrictions.eq("password", password));
			list = criteria.list();
			
			if (list.size() > 0) {
				dto = (UserDTO) list.get(0);
			} else {
				dto = null ;
			}
			return dto;
		}

		public List search(UserDTO dto, int pageNo, int pageSize) {
			List list = null;
			
			Session session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(UserDTO.class);
			
			if (dto != null) {
				if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
					criteria.add(Restrictions.like("firstName", dto.getFirstName() + "%"));
				}
			}
			
			if(pageSize > 0) {
				pageNo = (pageNo -1) * pageSize;
				criteria.setFirstResult(pageNo);
				criteria.setMaxResults(pageSize);	
			}
			list = criteria.list();
			return list;
		}
 
		}
