package com.dekan.mall.common.converters;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.collections.AbstractCollectionConverter;
import com.thoughtworks.xstream.io.ExtendedHierarchicalStreamWriterHelper;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.mapper.Mapper;

/**
 * @ClassName MapConverter
 * @Description TODO【xstream转xml map转换器】
 * @Author Shiyz
 * @Date 2016-08-04 上午10:04:07
 */
@SuppressWarnings({ "rawtypes","unchecked" })
public class MapConverter extends AbstractCollectionConverter {

	public MapConverter(Mapper mapper) {
		super(mapper);
	}

	/**
	 * @Title canConvert
	 * @Description 
	 * @param class1
	 * @return
	 * @see com.thoughtworks.xstream.converters.collections.AbstractCollectionConverter#canConvert(java.lang.Class)
	 */
	@Override
	public boolean canConvert(Class type) {
		 return type.equals(HashMap.class)  
	                || type.equals(Hashtable.class)  
	                || type.getName().equals("java.util.LinkedHashMap")  
	                || type.getName().equals("sun.font.AttributeMap")
	                || type.getName().equals("java.util.concurrent.ConcurrentHashMap");  
	}

	/**
	 * @Title marshal
	 * @Description 
	 * @param obj
	 * @param hierarchicalstreamwriter
	 * @param marshallingcontext
	 * @see com.thoughtworks.xstream.converters.collections.AbstractCollectionConverter#marshal(java.lang.Object, com.thoughtworks.xstream.io.HierarchicalStreamWriter, com.thoughtworks.xstream.converters.MarshallingContext)
	 */
	@Override
	public void marshal(Object obj,
			HierarchicalStreamWriter writer,
			MarshallingContext context) {
		Map map = (Map) obj;
		for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext(); writer
				.endNode()) {
			java.util.Map.Entry entry = (java.util.Map.Entry) iterator.next();
			//System.out.println(entry.getKey().toString());
			ExtendedHierarchicalStreamWriterHelper.startNode(writer,(String) entry.getKey(),entry.getClass());
			writeItem(entry.getValue(), context, writer);
		}

	}

	/**
	 * @Title unmarshal
	 * @Description 
	 * @param hierarchicalstreamreader
	 * @param unmarshallingcontext
	 * @return
	 * @see com.thoughtworks.xstream.converters.collections.AbstractCollectionConverter#unmarshal(com.thoughtworks.xstream.io.HierarchicalStreamReader, com.thoughtworks.xstream.converters.UnmarshallingContext)
	 */
	@Override
	  public Object unmarshal(HierarchicalStreamReader reader,
	    	    UnmarshallingContext context) {
	    	   Map map = (Map) new HashMap();
	    	   reader.moveUp();
	    	   map.put(reader.getNodeName(), reader.getValue());
	    	   return map;
	    }
}
