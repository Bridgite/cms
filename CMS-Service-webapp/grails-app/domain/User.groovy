

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class User implements Serializable {
  
	private static final long serialVersionUID = 1

	transient springSecurityService

	String username
	String password
        String countrycode 
        String email
	boolean enabled = true
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

	User(String username, String password, String countrycode,String email) {
		this()
		this.username = username
		this.password = password
                this.countrycode = countrycode
                this.email = email
	}

	Set<Role> getAuthorities() {
		UserRole.findAllByUser(this)*.role
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
	}

	static transients = ['springSecurityService']

	static constraints = {
		username blank: false, unique: true
		password blank: false
                countrycode blank: false
                email blank: false
	}

	static mapping = {
                table 'e_cert_users'
		password column: '`password`'
	}
}
