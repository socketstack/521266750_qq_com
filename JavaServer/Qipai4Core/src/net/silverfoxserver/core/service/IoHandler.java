/*
 * SilverFoxServer: massive multiplayer game server for Flash, ...
 * VERSION:3.0
 * PUBLISH DATE:2015-9-2 
 * GITHUB:github.com/wdmir/521266750_qq_com
 * UPDATES AND DOCUMENTATION AT: http://www.silverfoxserver.net
 * COPYRIGHT 2009-2015 SilverFoxServer.NET. All rights reserved.
 * MAIL:521266750@qq.com
 */
package net.silverfoxserver.core.service;

//

import System.Xml.XmlDocument;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;


/**
 * Handles all I/O events fired by MINA.
 *
 * @author <a href="http://mina.apache.org">Apache MINA Project</a>
 *
 * @see IoHandlerAdapter
 */
public interface IoHandler
{
     
/**
 * 
 * 
 */
 void  handleUpstream(ChannelHandlerContext ctx, ChannelEvent e);
   
	/**
 * Invoked from an I/O processor thread when a new connection has been created.
 * Because this method is supposed to be called from the same thread that
 * handles I/O of multiple sessions, please implement this method to perform
 * tasks that consumes minimal amount of time such as socket parameter
 * and user-defined session attribute initialization.
 */
void sessionCreated(ChannelHandlerContext ctx, ChannelStateEvent e); //IoSession session

/**
 * Invoked when a connection has been opened.  This method is invoked after
 * {@link #sessionCreated(IoSession)}.  The biggest difference from
 * {@link #sessionCreated(IoSession)} is that it's invoked from other thread
 * than an I/O processor thread once thread model is configured properly.
 */
void sessionOpened(); //IoSession session

/**
 * Invoked when a connection is closed.
 */
void sessionClosed(ChannelHandlerContext ctx, ChannelStateEvent e); //IoSession session

/**
 * Invoked with the related {@link IdleStatus} when a connection becomes idle.
 * This method is not invoked if the transport type is UDP; it's a known bug,
 * and will be fixed in 2.0.
 */
//void sessionIdle(); //IoSession session, IdleStatus status

/**
 * Invoked when a message is received.
 */
//void messageReceived(Socket session, Object message);//IoSession session, Object message
void messageReceived(ChannelHandlerContext ctx, MessageEvent e,XmlDocument d);

/**
 * Invoked when a message written by {@link IoSession#write(Object)} is
 * sent out.
 */
//void messageSent(); //IoSession session, Object message

/**
 * Invoked when any exception is thrown by user {@link IoHandler}
 * implementation or by MINA.  If <code>cause</code> is an instance of
 * {@link IOException}, MINA will close the connection automatically.
 */
void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e); //IoSession session, Throwable cause


}
