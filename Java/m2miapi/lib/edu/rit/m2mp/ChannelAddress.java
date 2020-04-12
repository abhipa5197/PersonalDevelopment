//******************************************************************************
//
// File:    ChannelAddress.java
// Package: edu.rit.m2mp
// Unit:    Interface edu.rit.m2mp.ChannelAddress
//
// This Java source file is copyright (C) 2001, 2002 by the Rochester Institute
// of Technology. All rights reserved. For further information, contact the
// author, Alan Kaminsky, at ark@it.rit.edu.
//
// This Java source file is part of the M2MP Library ("The Library"). The
// Library is free software; you can redistribute it and/or modify it under the
// terms of the GNU General Public License as published by the Free Software
// Foundation; either version 2 of the License, or (at your option) any later
// version.
//
// The Library is distributed in the hope that it will be useful, but WITHOUT
// ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
// FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
// details.
//
// A copy of the GNU General Public License is provided in the file gpl.txt. You
// may also obtain a copy of the GNU General Public License on the World Wide
// Web at http://www.gnu.org/licenses/gpl.html or by writing to the Free
// Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307
// USA.
//
//******************************************************************************

package edu.rit.m2mp;

/**
 * Interface ChannelAddress is a tagging interface for a channel address in the
 * Many-to-Many Protocol (M2MP). An M2MP channel (interface {@link Channel
 * </CODE>Channel<CODE>}) uses a channel address to identify itself to other
 * M2MP channels, allowing other M2MP channels to send M2MP messages to it. Each
 * Channel class uses a ChannelAddress class containing the proper information
 * for that kind of channel.
 * <P>
 * <B>M2MP Library Version 02-Jul-2002</B>
 *
 * @author  Alan Kaminsky
 * @version 01-Nov-2001
 */
public interface ChannelAddress
	{
	}