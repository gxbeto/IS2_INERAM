package com.wwpbaseobjects ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSplitScreenDetailInfo", namespace ="Gregory")
public final  class StructSdtColSplitScreenDetailInfo implements Cloneable, java.io.Serializable
{
   public StructSdtColSplitScreenDetailInfo( )
   {
      this( -1, new ModelContext( StructSdtColSplitScreenDetailInfo.class ));
   }

   public StructSdtColSplitScreenDetailInfo( int remoteHandle ,
                                             ModelContext context )
   {
   }

   public  StructSdtColSplitScreenDetailInfo( java.util.Vector<StructSdtSplitScreenDetailInfo> value )
   {
      item = value;
   }

   public Object clone()
   {
      Object cloned = null;
      try
      {
         cloned = super.clone();
      }catch (CloneNotSupportedException e){ ; }
      return cloned;
   }

   @javax.xml.bind.annotation.XmlElement(name="SplitScreenDetailInfo",namespace="Gregory")
   public java.util.Vector<StructSdtSplitScreenDetailInfo> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSplitScreenDetailInfo> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSplitScreenDetailInfo> item = new java.util.Vector<>();
}

