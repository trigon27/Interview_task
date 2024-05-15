import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.interveiwtask.R
import com.example.interveiwtask.User
import java.util.*

class UserAdapter(private var userList: List<User>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>(), Filterable {

    private var userListFiltered: List<User> = userList

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Initialize views in the item layout
        val userNameTextView: TextView = itemView.findViewById(R.id.userNameTextView)
        val userEmailTextView: TextView = itemView.findViewById(R.id.userEmailTextView)
        val userAvatarImageView: ImageView = itemView.findViewById(R.id.userAvatarImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        // Inflate the item layout and return a ViewHolder
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_item, parent, false)
        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        // Bind data from user object to views in the item layout
        val currentUser = userListFiltered[position]
        holder.userNameTextView.text = "${currentUser.first_name} ${currentUser.last_name}"
        holder.userEmailTextView.text = currentUser.email
        // Load user avatar image using a library like Glide or Picasso
        Glide.with(holder.itemView.context)
            .load(currentUser.avatar)
            .placeholder(R.drawable.boy) // Placeholder image while loading
            .error(R.drawable.error) // Error image if loading fails
            .into(holder.userAvatarImageView)
    }

    override fun getItemCount() = userListFiltered.size

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charString = constraint.toString()
                userListFiltered = if (charString.isEmpty()) {
                    userList
                } else {
                    val filteredList = mutableListOf<User>()
                    for (user in userList) {
                        if (user.first_name.toLowerCase(Locale.getDefault()).contains(charString.toLowerCase()) ||
                            user.last_name.toLowerCase(Locale.getDefault()).contains(charString.toLowerCase()) ||
                            user.email.toLowerCase(Locale.getDefault()).contains(charString.toLowerCase())
                        ) {
                            filteredList.add(user)
                        }
                    }
                    filteredList
                }
                val filterResults = FilterResults()
                filterResults.values = userListFiltered
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                userListFiltered = results?.values as List<User>
                notifyDataSetChanged()
            }
        }
    }
}
