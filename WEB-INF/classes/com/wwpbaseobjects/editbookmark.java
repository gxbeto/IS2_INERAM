package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.wwpbaseobjects.editbookmark", "/com.wwpbaseobjects.editbookmark"})
public final  class editbookmark extends GXWebPanelStub
{
   public editbookmark( )
   {
   }

   public editbookmark( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( editbookmark.class ));
   }

   public editbookmark( int remoteHandle ,
                        ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new editbookmark_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new editbookmark_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Add/Edit Bookmark";
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

