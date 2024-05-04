package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.wwpbaseobjects.login", "/com.wwpbaseobjects.login"})
public final  class login extends GXWebPanelStub
{
   public login( )
   {
   }

   public login( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( login.class ));
   }

   public login( int remoteHandle ,
                 ModelContext context )
   {
      super(remoteHandle, context);
   }

   public static void main( String args[] )
   {
      ApplicationContext.getInstance().setCurrentLocation( "" );
      Application.init(com.GXcfg.class);
      com.wwpbaseobjects.login_impl pgm = new com.wwpbaseobjects.login_impl (-1);
      Application.realMainProgram = pgm;
      pgm.executeCmdLine(args);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new login_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new login_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Sample Log In";
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

