package ic2.api.network;

import java.util.Collection;
import java.util.Map;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

public interface INetworkDataProvider
{
	/**
	 * Returns the fields this object has
	 */
	ImmutableList<String> getNetworkedFields();

	/**
	 * Request the specified fields from this object
	 * 
	 * @param fields
	 */
	ImmutableMap<String, Object> getFieldsForSync(Collection<String> fields);

	/**
	 * Update all fields present in the map
	 */
	void updateFields(Map<String, Object> fields);
}
