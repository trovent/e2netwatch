
/*
    Copyright (C) 2017 e-ito Technology Services GmbH
    e-mail: info@e-ito.de
    
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/


package hr.eito.e2nwkite.usermanagement.helper;

/**
 * Helper interface for getting necessary information 
 * from HttpServletRequest for user management
 *
 * @author Hrvoje
 */
public interface RequestMiner {
	
	/**
	 * Getting username for the current user.
	 * <p>From request cookie username is pulled
	 * 
	 * @return usernama as String or null if nothing found
	 */
	public String getCurrentUsername();
	
}
