package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.wwpbaseobjects.workwithplusmasterpageempty", "/com.wwpbaseobjects.workwithplusmasterpageempty"})
public final  class workwithplusmasterpageempty extends GXWebPanelStub
{
   public workwithplusmasterpageempty( )
   {
   }

   public workwithplusmasterpageempty( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( workwithplusmasterpageempty.class ));
   }

   public workwithplusmasterpageempty( int remoteHandle ,
                                       ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new workwithplusmasterpageempty_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new workwithplusmasterpageempty_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Master Page";
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

