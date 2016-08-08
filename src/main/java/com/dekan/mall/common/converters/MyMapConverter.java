package com.dekan.mall.common.converters;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.collections.AbstractCollectionConverter;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.mapper.Mapper;

/**
 * @ClassName MapConverter
 * @Description TODO【xstream转xml map转换器】
 * @Author Shiyz
 * @Date 2016-08-04 上午10:04:07
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class MyMapConverter extends AbstractCollectionConverter {

	public MyMapConverter(Mapper mapper) {
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
				|| type.getName().equals(
						"java.util.concurrent.ConcurrentHashMap");
	}

	/**
	 * @Title marshal
	 * @Description
	 * @param obj
	 * @param hierarchicalstreamwriter
	 * @param marshallingcontext
	 * @see com.thoughtworks.xstream.converters.collections.AbstractCollectionConverter#marshal(java.lang.Object,
	 *      com.thoughtworks.xstream.io.HierarchicalStreamWriter,
	 *      com.thoughtworks.xstream.converters.MarshallingContext)
	 */
	public void marshal(Object source, HierarchicalStreamWriter writer,
			MarshallingContext context) {
		Map map = (Map) source;
		for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext();) {
			Map.Entry entry = (Map.Entry) iterator.next();
			Object key = entry.getKey();
			Object value = entry.getValue();
			if (key instanceof String) {
				writer.startNode((String) key);
				if (value == null)
					writer.setValue("");
				if (value instanceof String) {
					writer.setValue((String) value);
				} else if (value.getClass().isArray()){
					 int length = Array.getLength(value);
					 	//String name = mapper().serializedClass(null);
			            //ExtendedHierarchicalStreamWriterHelper.startNode(writer, name, com.thoughtworks.xstream.mapper.Mapper.Null.class);
					 	//Object val = Array.get(value, i);
			        	//context.convertAnother(value);
					/* ExtendedHierarchicalStreamWriterHelper.startNode(writer, "", Array.class);
					 writer.endNode();*/
					 List<String> list = new ArrayList<String>();
					 for(int i = 0; i < length; i++){
						 list.add(String.valueOf(Array.get(value, i)));
				     }
					 writer.setValue("[" + StringUtils.join(list,",") + "]");
				        //writer.endNode();
				} else {
					/*ExtendedHierarchicalStreamWriterHelper.startNode(writer,
							(String) key, value.getClass());*/
					writer.startNode((String) key);
					//writeItem(entry.getValue(), context, writer);
					context.convertAnother(value);
				}
			} else {
				writer.startNode(mapper().serializedClass(Map.Entry.class));
				writeItem(entry.getKey(), context, writer);
				writeItem(entry.getValue(), context, writer);
			}
			writer.endNode();
		}
	}

	public Object unmarshal(HierarchicalStreamReader reader,
			UnmarshallingContext context) {
		Map map = (Map) createCollection(context.getRequiredType());
		populateMap(reader, context, map);
		return map;
	}

	protected void populateMap(HierarchicalStreamReader reader,
			UnmarshallingContext context, Map map) {
		while (reader.hasMoreChildren()) {
			reader.moveDown();

			if (reader.getNodeName().equals(
					mapper().serializedClass(Map.Entry.class))) {
				reader.moveDown();
				Object key = readItem(reader, context, map);
				reader.moveUp();

				reader.moveDown();
				Object value = readItem(reader, context, map);
				reader.moveUp();

				map.put(key, value);
			} else {
				Object key = reader.getNodeName();
				Object value = reader.getValue();
				if (value == null || ((String) value).trim().length() == 0) {
					String classAttribute = reader.getAttribute(mapper()
							.aliasForAttribute("class"));
					Class type;
					if (classAttribute == null) {
						type = map.getClass();
					} else {
						type = mapper().realClass(classAttribute);
					}
					value = context.convertAnother(map, type);
				}
				map.put(key, value);
			}

			reader.moveUp();
		}
	}

}
