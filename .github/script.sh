        echo 0 > long
        for file in $(find . -iname "*.java"); do 
          lineno=0
          echo "Processing file: $file"
          cat $file | while read -r line; do 
            longlines="$(cat long)"
            ((lineno=lineno+1))
            count=$(echo $line | wc -m)
            if [[ $count -gt 80 ]]; then 
              echo "Line $lineno in $file has $count characters."
              ((longlines=longlines+1))
              echo $longlines > long
            fi
          done
        done
        longlines="$(cat long)"
        rm long
        if [[ $longlines -gt 0 ]]; then 
          echo "You have long lines in your code!"
          exit 1
        fi
# longlines=0; for file in $(find . -iname "*.java"); do lineno=0; cat $file | while read -r line; do ((lineno=lineno+1)); count=$(echo $line | wc -m); if [[ $count -gt 80 ]]; then echo "Line $lineno in $file has $count characters."; ((longlines=longlines+1)); fi; done; done; if [[ $longlines -gt 0 ]]; then exit 1; fi
