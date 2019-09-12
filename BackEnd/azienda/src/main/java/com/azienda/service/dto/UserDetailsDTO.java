package com.azienda.service.dto;

public class UserDetailsDTO {

	

		private int idUser;
	    private String username;
	    private String password;
	   

	    public static UserDetailsDTO build(int idUser,String username, String password){
	        UserDetailsDTO userDTO = new UserDetailsDTO();
	        userDTO.setUsername(username);
	        userDTO.setPassword(password);
	        userDTO.setIdUser(idUser);
	        return userDTO;
	    }


		/**
		 * @return the idUser
		 */
		public int getIdUser() {
			return idUser;
		}


		/**
		 * @param idUser the idUser to set
		 */
		public void setIdUser(int idUser) {
			this.idUser = idUser;
		}


		/**
		 * @return the username
		 */
		public String getUsername() {
			return username;
		}


		/**
		 * @param username the username to set
		 */
		public void setUsername(String username) {
			this.username = username;
		}


		/**
		 * @return the password
		 */
		public String getPassword() {
			return password;
		}


		/**
		 * @param password the password to set
		 */
		public void setPassword(String password) {
			this.password = password;
		}
	    
	    
	    
}


