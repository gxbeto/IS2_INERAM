package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.wwpbaseobjects.menuitem", "/com.wwpbaseobjects.menuitem"})
public final  class menuitem extends GXWebPanelStub
{
   public menuitem( )
   {
   }

   public menuitem( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( menuitem.class ));
   }

   public menuitem( int remoteHandle ,
                    ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new menuitem_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new menuitem_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Menu Item";
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

